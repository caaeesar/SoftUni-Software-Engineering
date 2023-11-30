package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PostRootSeedDto;
import softuni.exam.instagraphlite.models.dto.PostSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidationUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final static String SUCCESSFUL_MESSAGE = "Successfully imported Post, made by %s";
    private final static String INVALID_MESSAGE = "Invalid Post";
    private final static String POST_FILE_PATH = "src/main/resources/files/posts.xml";
    private final PostRepository postRepository;
    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PictureRepository pictureRepository, UserRepository userRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.postRepository = postRepository;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POST_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder message = new StringBuilder();

        List<PostSeedDto> postSeedDtos = xmlParser.deserialize(PostRootSeedDto.class, Path.of(POST_FILE_PATH).toFile()).getPosts().stream().collect(Collectors.toList());

        for (PostSeedDto postSeedDto : postSeedDtos) {

            if (isExistUserWithUsername(postSeedDto.getUser().getUsername())
            && isExistUserWithProfilePicture(postSeedDto.getPicture().getPath())
            && validationUtil.isValid(postSeedDto)) {

                Post post = mapper.map(postSeedDto, Post.class);
                User user = userRepository.findUserByUsername(postSeedDto.getUser().getUsername()).get();
                Picture picture = pictureRepository.findPictureByPath(postSeedDto.getPicture().getPath()).get();
                post.setUser(user);
                post.setPicture(picture);

                postRepository.save(post);
                message.append(String.format(SUCCESSFUL_MESSAGE, post.getUser().getUsername())).append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistUserWithProfilePicture(String path) {
        return pictureRepository.findPictureByPath(path).isPresent();
    }

    private boolean isExistUserWithUsername(String username) {
        return userRepository.findUserByUsername(username).isPresent();
    }
}
