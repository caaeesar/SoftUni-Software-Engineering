package bg.softuni.shoppinglistapplication.service;

import bg.softuni.shoppinglistapplication.model.service.UserServiceModel;

public interface UserService {
    boolean registerUser(UserServiceModel userServiceModel);

    boolean checkUserCredentials(UserServiceModel userServiceModel);

    void loginUser(UserServiceModel userServiceModel);

    void logout();
}
