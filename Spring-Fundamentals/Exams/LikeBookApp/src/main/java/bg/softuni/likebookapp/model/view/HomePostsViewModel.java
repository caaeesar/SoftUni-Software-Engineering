package bg.softuni.likebookapp.model.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HomePostsViewModel {

    private List<MyPostsViewModel> myPosts;
    private List<OtherPostsViewModel> otherPosts;

    public HomePostsViewModel(List<MyPostsViewModel> myPosts, List<OtherPostsViewModel> otherPosts) {
        this.myPosts = myPosts;
        this.otherPosts = otherPosts;
    }
}
