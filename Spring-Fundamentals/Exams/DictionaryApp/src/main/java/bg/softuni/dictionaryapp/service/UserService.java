package bg.softuni.dictionaryapp.service;

import bg.softuni.dictionaryapp.model.service.UserServiceModel;

public interface UserService {
    boolean registerUser(UserServiceModel userServiceModel);

    boolean checkUserCredentials(UserServiceModel userServiceModel);

    void loginUser(UserServiceModel userServiceModel);

    void logoutUser();

}
