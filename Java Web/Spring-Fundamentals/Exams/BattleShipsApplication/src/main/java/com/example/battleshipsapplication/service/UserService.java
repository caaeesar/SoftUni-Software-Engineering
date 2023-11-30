package com.example.battleshipsapplication.service;

import com.example.battleshipsapplication.model.binding.UserLoginBindingModel;
import com.example.battleshipsapplication.model.binding.UserRegisterBindingModel;

public interface UserService {

    boolean registerUser(UserRegisterBindingModel userRegisterBindingModel);

    void loginUser(UserLoginBindingModel userLoginBindingModel);

    boolean checkUserCredentials(UserLoginBindingModel userLoginBindingModel);

    void logoutUser();
}
