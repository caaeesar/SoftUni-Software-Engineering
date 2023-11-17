package com.example.pathfinder.service;

import com.example.pathfinder.model.binding.UserLoginBindingModel;
import com.example.pathfinder.model.binding.UserRegisterBindingModel;
import com.example.pathfinder.model.entity.UserEntity;

public interface UserService {

    void registerUser(UserRegisterBindingModel userRegisterBindingModel);
    boolean loginUser(UserLoginBindingModel userLoginBindingModel);

    void logoutUser();

    UserEntity getLoggedUser();

    UserEntity findById(Long id);

}
