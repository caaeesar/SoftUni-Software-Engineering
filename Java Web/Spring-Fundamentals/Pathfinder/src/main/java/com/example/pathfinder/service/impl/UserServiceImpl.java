package com.example.pathfinder.service.impl;

import com.example.pathfinder.exceptions.UserAlreadyExistException;
import com.example.pathfinder.exceptions.UserNotExistException;
import com.example.pathfinder.model.binding.UserLoginBindingModel;
import com.example.pathfinder.model.binding.UserRegisterBindingModel;
import com.example.pathfinder.model.entity.UserEntity;
import com.example.pathfinder.model.entity.enums.UserLevel;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.UserService;
import com.example.pathfinder.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    private final LoggedUser loggedUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    @Override
    public void registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(userRegisterBindingModel.getUsername());
        if (optionalUserEntity.isPresent()) {
            throw new UserAlreadyExistException("User with this username already exist.");
        }
        userRegisterBindingModel.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        UserEntity userEntity = modelMapper.map(userRegisterBindingModel, UserEntity.class);
        // default level
        userEntity.setLevel(UserLevel.BEGINNER);
        userRepository.save(userEntity);
    }

    @Override
    public boolean loginUser(UserLoginBindingModel userLoginBindingModel) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(userLoginBindingModel.getUsername());
        if (optionalUserEntity.isEmpty()) {
            throw new UserNotExistException("User with this username is not present.");
        }

        UserEntity userEntity = optionalUserEntity.get();
        boolean isMatchedPass = passwordEncoder.matches(userLoginBindingModel.getPassword(), userEntity.getPassword());
        if (isMatchedPass) {
            loggedUser.setId(userEntity.getId());
            loggedUser.setUsername(userEntity.getUsername());
            loggedUser.setLogged(true);
            return true;
        }
        throw new IllegalArgumentException("User entered incorrect password.");
    }

    @Override
    public void logoutUser() {
        loggedUser.reset();
    }

    @Override
    public UserEntity getLoggedUser() {
        return userRepository.getByUsername(loggedUser.getUsername());
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).get();
    }
}
