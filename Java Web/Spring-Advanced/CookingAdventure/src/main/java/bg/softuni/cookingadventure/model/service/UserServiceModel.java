package bg.softuni.cookingadventure.model.service;

import bg.softuni.cookingadventure.model.entity.enums.RoleName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserServiceModel {

    private String email;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private int age;

    private RoleName role;
}
