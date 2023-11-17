package com.example.resellerapp.service.impl;

import com.example.resellerapp.model.binding.UserLoginBindingModel;
import com.example.resellerapp.model.binding.UserRegisterBindingModel;
import com.example.resellerapp.model.entity.User;
import com.example.resellerapp.repository.UserRepository;
import com.example.resellerapp.service.UserService;
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

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        userRepository.save(user);
    }

    @Override
    public boolean loginUser(UserLoginBindingModel userLoginBindingModel) {
        Optional<User> user = userRepository.findByUsername(userLoginBindingModel.getUsername());
        if (user.isPresent()) {
            boolean areMatches = passwordEncoder.matches(userLoginBindingModel.getPassword(), user.get().getPassword());
            if (areMatches) {
                return true;
            }
        }
        return false;
    }
}
