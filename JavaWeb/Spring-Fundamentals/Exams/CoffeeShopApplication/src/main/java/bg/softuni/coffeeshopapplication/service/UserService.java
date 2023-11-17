package bg.softuni.coffeeshopapplication.service;

import bg.softuni.coffeeshopapplication.model.binding.UserRegisterBindingModel;
import bg.softuni.coffeeshopapplication.model.service.UserServiceModel;
import bg.softuni.coffeeshopapplication.model.view.UserViewModel;

import java.util.List;

public interface UserService {

    void registerUser(UserRegisterBindingModel userRegisterBindingModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(UserServiceModel userServiceModel);

    void logoutUser();

    List<UserViewModel> findAllEmployees();
}
