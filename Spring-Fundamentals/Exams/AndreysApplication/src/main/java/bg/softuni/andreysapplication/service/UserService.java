package bg.softuni.andreysapplication.service;

import bg.softuni.andreysapplication.model.service.UserServiceModel;

public interface UserService {
    boolean registerUser(UserServiceModel userServiceModel);

    boolean checkCredentials(UserServiceModel userServiceModel);

    void loginUser(UserServiceModel userServiceModel);

    void logoutUser();
}
