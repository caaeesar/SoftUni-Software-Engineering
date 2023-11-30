package bg.softuni.cookingadventure.model.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileViewModel {

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private int age;
}
