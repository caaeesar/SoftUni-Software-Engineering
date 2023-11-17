package bg.softuni.shoppinglistapplication.service.impl;

import bg.softuni.shoppinglistapplication.model.entity.User;
import bg.softuni.shoppinglistapplication.model.service.UserServiceModel;
import bg.softuni.shoppinglistapplication.repository.UserRepository;
import bg.softuni.shoppinglistapplication.service.UserService;
import bg.softuni.shoppinglistapplication.session.LoggedUser;
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
    public boolean registerUser(UserServiceModel userServiceModel) {
        Optional<User> byUsername = userRepository.findUserByUsername(userServiceModel.getUsername());
        Optional<User> byEmail = userRepository.findUserByEmail(userServiceModel.getEmail());
        if (byUsername.isPresent() || byEmail.isPresent()) {
            return false;
        }

        User user = modelMapper.map(userServiceModel, User.class);
        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean checkUserCredentials(UserServiceModel userServiceModel) {
        Optional<User> optionalUser = userRepository.findUserByUsername(userServiceModel.getUsername());
        if (optionalUser.isEmpty()) {
            return false;
        }

        User user = optionalUser.get();
        boolean isMatches = passwordEncoder.matches(userServiceModel.getPassword(), user.getPassword());

        return isMatches;
    }

    @Override
    public void loginUser(UserServiceModel userServiceModel) {
        loggedUser.setUsername(userServiceModel.getUsername());
        loggedUser.setLogged(true);
    }

    @Override
    public void logout() {
        loggedUser.setLogged(false);
        loggedUser.setUsername(null);
    }
}
