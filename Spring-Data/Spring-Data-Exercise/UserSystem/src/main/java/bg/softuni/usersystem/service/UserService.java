package bg.softuni.usersystem.service;

import bg.softuni.usersystem.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsersWithEmailProvider(String emailProvider);

    void register(User user);

    int removeInactiveUsers();
}
