package bg.softuni.likebookapp.service;

import bg.softuni.likebookapp.model.service.UserServiceModel;

public interface UserService {


    boolean registerUser(UserServiceModel userServiceModel);

    boolean checkCredentials(UserServiceModel userServiceModel);

    void loginUser(UserServiceModel userServiceModel);

    void logout();
}
