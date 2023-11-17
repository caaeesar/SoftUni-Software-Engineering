package com.example.mobilelelewebapplication.service.impl;

import com.example.mobilelelewebapplication.model.dto.UserLoginDto;
import com.example.mobilelelewebapplication.model.dto.UserRegistrationDto;
import com.example.mobilelelewebapplication.model.entity.UserEntity;
import com.example.mobilelelewebapplication.model.entity.RoleEntity;
import com.example.mobilelelewebapplication.repository.UserRepository;
import com.example.mobilelelewebapplication.repository.RoleRepository;
import com.example.mobilelelewebapplication.service.UserService;
import com.example.mobilelelewebapplication.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    private final LoggedUser loggedUser;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper, LoggedUser loggedUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegistrationDto userRegistrationDto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(userRegistrationDto.getUsername());
        if (optionalUserEntity.isEmpty()) {
        UserEntity userEntity = modelMapper.map(userRegistrationDto,UserEntity.class);
        RoleEntity userRoleEntity = roleRepository.getByNameIs(userRegistrationDto.getRole());
        userEntity.setRole(userRoleEntity);
        userEntity.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        userRepository.save(userEntity);
        }
    }

    @Override
    public boolean loginUser(UserLoginDto userLoginDto) {
       Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(userLoginDto.getUsername());
       if (optionalUserEntity.isPresent()) {

           UserEntity userEntity = optionalUserEntity.get();
          if (passwordEncoder.matches(userLoginDto.getPassword(), userEntity.getPassword())) {
              loggedUser.setFirstName(userEntity.getFirstName());
              loggedUser.setId(userEntity.getId());
              loggedUser.setLogged(true);
              return true;
          }
       }
       return false;
    }

    @Override
    public UserEntity getLoggedUser() {
        return userRepository.findByUsername(loggedUser.getUsername()).get();
    }

    @Override
    public void logoutUser() {
        loggedUser.reset();
    }
}
