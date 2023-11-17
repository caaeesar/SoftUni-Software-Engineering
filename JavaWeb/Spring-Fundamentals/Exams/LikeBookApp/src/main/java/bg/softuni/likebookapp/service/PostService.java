package bg.softuni.likebookapp.service;

import bg.softuni.likebookapp.model.service.PostServiceModel;
import bg.softuni.likebookapp.model.view.HomePostsViewModel;

public interface PostService {
    void createPost(PostServiceModel postServiceModel);

    HomePostsViewModel findAllPostsForHomePage();

    void likePost(String id);

    void removePost(String id);
}
