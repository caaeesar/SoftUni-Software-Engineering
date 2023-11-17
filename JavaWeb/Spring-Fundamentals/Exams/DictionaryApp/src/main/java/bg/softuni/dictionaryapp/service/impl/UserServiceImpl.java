package bg.softuni.dictionaryapp.service.impl;

import bg.softuni.dictionaryapp.model.entity.User;
import bg.softuni.dictionaryapp.model.service.UserServiceModel;
import bg.softuni.dictionaryapp.repository.UserRepository;
import bg.softuni.dictionaryapp.service.UserService;
import bg.softuni.dictionaryapp.session.SessionUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final SessionUser sessionUser;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(SessionUser sessionUser, UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.sessionUser = sessionUser;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
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
    public boolean checkUserCredentials(UserServiceModel userServiceModel) {
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
