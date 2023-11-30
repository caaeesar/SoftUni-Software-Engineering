package com.example.battleshipsapplication.service.impl;

import com.example.battleshipsapplication.model.binding.UserLoginBindingModel;
import com.example.battleshipsapplication.model.binding.UserRegisterBindingModel;
import com.example.battleshipsapplication.model.entity.User;
import com.example.battleshipsapplication.repository.UserRepository;
import com.example.battleshipsapplication.service.UserService;
import com.example.battleshipsapplication.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        Optional<User> optionalUserByUsername = userRepository.findUserByUsername(userRegisterBindingModel.getUsername());
        if (optionalUserByUsername.isPresent()) {
            return false;
        }

        Optional<User> optionalUserByEmail = userRepository.findUserByEmail(userRegisterBindingModel.getEmail());
        if (optionalUserByEmail.isPresent()) {
            return false;
        }

        User user = modelMapper.map(userRegisterBindingModel, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public void loginUser(UserLoginBindingModel userLoginBindingModel) {
        loggedUser.setLogged(true);
        loggedUser.setUsername(userLoginBindingModel.getUsername());
    }

    @Override
    public boolean checkUserCredentials(UserLoginBindingModel userLoginBindingModel) {
        Optional<User> optionalUser = userRepository.findUserByUsername(userLoginBindingModel.getUsername());
        if (optionalUser.isEmpty()) {
            return false;
        }

        User user = optionalUser.get();
        boolean isMatches = passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword());

        return isMatches;
    }

    @Override
    public void logoutUser() {
        loggedUser.setLogged(false);
        loggedUser.setUsername(null);
    }
}
