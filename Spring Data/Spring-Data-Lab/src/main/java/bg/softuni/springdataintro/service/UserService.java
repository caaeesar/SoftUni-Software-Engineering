package bg.softuni.springdataintro.service;

import bg.softuni.springdataintro.entity.User;

import java.util.List;

public interface UserService {
    User register(User user);
    List<User> getAllUsers();
}
