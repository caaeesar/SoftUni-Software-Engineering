package com.example.mobilelelewebapplication.service;

import com.example.mobilelelewebapplication.model.dto.UserLoginDto;
import com.example.mobilelelewebapplication.model.dto.UserRegistrationDto;
import com.example.mobilelelewebapplication.model.entity.UserEntity;

public interface UserService {

    void registerUser(UserRegistrationDto userRegistrationDto);

    boolean loginUser(UserLoginDto userLoginDto);


    UserEntity getLoggedUser();

    void logoutUser();
}
