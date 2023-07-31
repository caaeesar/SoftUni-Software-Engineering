package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.UserExportDto;
import softuni.exam.instagraphlite.models.dto.UserSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final static String SUCCESSFUL_MESSAGE = "Successfully imported User: %s";
    private final static String INVALID_MESSAGE = "Invalid User";
    private final static String USER_FILE_PATH = "src/main/resources/files/users.json";
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PictureRepository pictureRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USER_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {

        TypeMap<UserSeedDto, User> typeMap = mapper.createTypeMap(UserSeedDto.class, User.class);
        typeMap.addMappings(mapping -> mapping.map(UserSeedDto::getProfilePicture,(destination, value) -> destination.getProfilePicture().setPath((String) value)));

        StringBuilder message = new StringBuilder();

        List<UserSeedDto> userSeedDtos = Arrays.stream(gson.fromJson(readFromFileContent(), UserSeedDto[].class)).collect(Collectors.toList());
        for (UserSeedDto userSeedDto : userSeedDtos) {

            if (!isExistUserWithUsername(userSeedDto.getUsername())
                    && isExistPictureWithPath(userSeedDto.getProfilePicture())
                    && validationUtil.isValid(userSeedDto)) {

                User user = typeMap.map(userSeedDto);
                Picture picture = pictureRepository.findPictureByPath(userSeedDto.getProfilePicture()).get();
                user.setProfilePicture(picture);
                userRepository.save(user);
                message.append(String.format(SUCCESSFUL_MESSAGE, user.getUsername())).append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistPictureWithPath(String path) {
        return pictureRepository.findPictureByPath(path).isPresent();
    }

    private boolean isExistUserWithUsername(String username) {
        return userRepository.findUserByUsername(username).isPresent();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        List<UserExportDto> users = userRepository.getUsersWithTheirPosts()
                .stream()
                .map(user -> mapper.map(user, UserExportDto.class))
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();

        users.forEach(user -> {
            result.append(String.format("User: %s",user.getUsername())).append(System.lineSeparator());
            result.append(String.format("Post count: %d", user.getPosts().size())).append(System.lineSeparator());

            user.getPosts().stream()
                    .sorted(Comparator.comparingDouble(post -> post.getPicture().getSize()))
                    .forEach(post -> {
                        result.append("==Post Details:").append(System.lineSeparator());
                        result.append(String.format("----Caption: %s", post.getCaption())).append(System.lineSeparator());
                        result.append(String.format("----Picture Size: %.2f", post.getPicture().getSize())).append(System.lineSeparator());
                    });

            result.append(System.lineSeparator());
        });

        return result.toString().trim();
    }
}
