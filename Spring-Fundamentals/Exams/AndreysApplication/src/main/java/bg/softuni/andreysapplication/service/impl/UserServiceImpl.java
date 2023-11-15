package bg.softuni.andreysapplication.service.impl;

import bg.softuni.andreysapplication.model.entity.User;
import bg.softuni.andreysapplication.model.service.UserServiceModel;
import bg.softuni.andreysapplication.repository.UserRepository;
import bg.softuni.andreysapplication.service.UserService;
import bg.softuni.andreysapplication.session.SessionUser;
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
    private final SessionUser sessionUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, SessionUser sessionUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.sessionUser = sessionUser;
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
        Optional<User> userByUsername = userRepository.findUserByUsername(userServiceModel.getUsername());
        if (userByUsername.isEmpty()) {
            return false;
        }

        User user = userByUsername.get();
        boolean isMatches = passwordEncoder.matches(userServiceModel.getPassword(), user.getPassword());
        return isMatches;
    }

    @Override
    public void loginUser(UserServiceModel userServiceModel) {
        sessionUser.setLogged(true);
    }

    @Override
    public void logoutUser() {
        sessionUser.setLogged(false);
    }
}
