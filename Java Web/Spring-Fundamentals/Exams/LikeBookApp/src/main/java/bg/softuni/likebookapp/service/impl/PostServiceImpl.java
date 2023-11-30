package bg.softuni.likebookapp.service.impl;

import bg.softuni.likebookapp.model.entity.Post;
import bg.softuni.likebookapp.model.entity.User;
import bg.softuni.likebookapp.model.service.PostServiceModel;
import bg.softuni.likebookapp.model.view.HomePostsViewModel;
import bg.softuni.likebookapp.model.view.MyPostsViewModel;
import bg.softuni.likebookapp.model.view.OtherPostsViewModel;
import bg.softuni.likebookapp.repository.MoodRepository;
import bg.softuni.likebookapp.repository.PostRepository;
import bg.softuni.likebookapp.repository.UserRepository;
import bg.softuni.likebookapp.service.PostService;
import bg.softuni.likebookapp.session.SessionUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final SessionUser sessionUser;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final MoodRepository moodRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(SessionUser sessionUser, PostRepository postRepository, UserRepository userRepository, MoodRepository moodRepository, ModelMapper modelMapper) {
        this.sessionUser = sessionUser;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.moodRepository = moodRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createPost(PostServiceModel postServiceModel) {
        Post post = modelMapper.map(postServiceModel, Post.class);
        post.setMood(moodRepository.getMoodByName(postServiceModel.getMood()));
        post.setCreator(userRepository.findUserByUsername(sessionUser.getUsername()).get());
        postRepository.save(post);
    }

    @Override
    public HomePostsViewModel findAllPostsForHomePage() {
        List<MyPostsViewModel> myPosts = new ArrayList<>();
        List<OtherPostsViewModel> otherPosts = new ArrayList<>();

        List<Post> allPosts = postRepository.findAll();

        for (int i = 0; i < allPosts.size(); i++) {
            Post post = allPosts.get(i);
            if (post.getCreator().getUsername().equals(sessionUser.getUsername())) {
                myPosts.add(modelMapper.map(post, MyPostsViewModel.class));
            } else {
                otherPosts.add(modelMapper.map(post, OtherPostsViewModel.class));
            }
        }

        return new HomePostsViewModel(myPosts, otherPosts);
    }

    @Override
    public void likePost(String id) {
        Post post = postRepository.findById(id).get();
        post.getUserLikes().add(userRepository.findUserByUsername(sessionUser.getUsername()).get());
        postRepository.save(post);
    }

    @Override
    public void removePost(String id) {
        postRepository.deleteById(id);
    }
}
