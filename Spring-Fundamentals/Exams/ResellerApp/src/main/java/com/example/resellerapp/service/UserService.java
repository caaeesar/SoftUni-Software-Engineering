package com.example.resellerapp.service;

import com.example.resellerapp.model.binding.UserLoginBindingModel;
import com.example.resellerapp.model.binding.UserRegisterBindingModel;

public interface UserService {

    void registerUser(UserRegisterBindingModel userRegisterBindingModel);

    boolean loginUser(UserLoginBindingModel userLoginBindingModel);
}
