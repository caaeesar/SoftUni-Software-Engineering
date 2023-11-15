package bg.softuni.coffeeshopapplication.service.impl;

import bg.softuni.coffeeshopapplication.model.binding.UserRegisterBindingModel;
import bg.softuni.coffeeshopapplication.model.entity.User;
import bg.softuni.coffeeshopapplication.model.service.UserServiceModel;
import bg.softuni.coffeeshopapplication.model.view.UserViewModel;
import bg.softuni.coffeeshopapplication.repository.UserRepository;
import bg.softuni.coffeeshopapplication.service.UserService;
import bg.softuni.coffeeshopapplication.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);
       // user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(UserServiceModel userServiceModel) {
        // set more fields
        loggedUser.setLogged(true);
        loggedUser.setId(userServiceModel.getId());
    }

    @Override
    public void logoutUser() {
        loggedUser.reset();
    }

    @Override
    public List<UserViewModel> findAllEmployees() {
        return userRepository.findUsersByOrdersCountDesc()
                .stream()
                .map(user -> modelMapper.map(user, UserViewModel.class))
                .collect(Collectors.toList());
    }
}
