package bg.softuni.plannerapp.service.impl;

import bg.softuni.plannerapp.model.entity.User;
import bg.softuni.plannerapp.model.service.UserServiceModel;
import bg.softuni.plannerapp.repository.UserRepository;
import bg.softuni.plannerapp.service.UserService;
import bg.softuni.plannerapp.session.SessionUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final SessionUser sessionUser;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(SessionUser sessionUser, UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.sessionUser = sessionUser;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registerUser(UserServiceModel userServiceModel) {
        Optional<User> userByUsername = userRepository.findUserByUsername(userServiceModel.getUsername());
        Optional<User> userByEmail = userRepository.findUserByEmail(userServiceModel.getEmail());
        if (userByUsername.isPresent() || userByEmail.isPresent()) {
            return false;
        }

        User user = modelMapper.map(userServiceModel, User.class);
        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean checkCredentials(UserServiceModel userServiceModel) {
        Optional<User> optionalUser = userRepository.findUserByUsername(userServiceModel.getUsername());
        if (optionalUser.isEmpty()) {
            return false;
        }

        User user = optionalUser.get();
        boolean isMatch = passwordEncoder.matches(userServiceModel.getPassword(), user.getPassword());
        return isMatch;
    }

    @Override
    public void loginUser(UserServiceModel userServiceModel) {
        sessionUser.setUsername(userServiceModel.getUsername());
        sessionUser.setLogged(true);
    }

    @Override
    public void logoutUser() {
        sessionUser.setUsername(null);
        sessionUser.setLogged(false);
    }
}
