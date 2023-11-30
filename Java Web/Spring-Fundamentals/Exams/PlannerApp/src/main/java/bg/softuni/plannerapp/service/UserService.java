package bg.softuni.plannerapp.service;

import bg.softuni.plannerapp.model.service.UserServiceModel;

public interface UserService {
    boolean registerUser(UserServiceModel userServiceModel);

    boolean checkCredentials(UserServiceModel userServiceModel);

    void loginUser(UserServiceModel userServiceModel);

    void logoutUser();
}
