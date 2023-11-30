package bg.softuni.usersystem.service.impl;

import bg.softuni.usersystem.entity.User;
import bg.softuni.usersystem.repository.UserRepository;
import bg.softuni.usersystem.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsersWithEmailProvider(String emailProvider) {
        return this.userRepo.getUsersByEmailEndsWith(emailProvider);
    }

    @Override
    public void register(User user) {
        this.userRepo.save(user);
    }


    @Override
    public int removeInactiveUsers() {
        List<User> users = this.userRepo.getUsersByLastTimeLoggedInBefore(LocalDate.of(2023, 7, 5));
        for (User user : users) {
            user.setDeleted(true);
        }
        return users.size();
    }
}
