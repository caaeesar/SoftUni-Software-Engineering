package bg.softuni.likebookapp.model.view;

import bg.softuni.likebookapp.model.entity.Mood;
import bg.softuni.likebookapp.model.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class OtherPostsViewModel {

    private String id;
    private String content;
    private Set<User> userLikes;
    private Mood mood;
    private User creator;

}
