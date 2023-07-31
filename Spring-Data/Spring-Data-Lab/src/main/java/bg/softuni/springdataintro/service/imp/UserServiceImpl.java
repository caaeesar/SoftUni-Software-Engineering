package bg.softuni.springdataintro.service.imp;

import bg.softuni.springdataintro.entity.User;
import bg.softuni.springdataintro.repository.UserRepository;
import bg.softuni.springdataintro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepo;

    @Autowired // ctr injection
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User register(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
     return userRepo.findAll();
    }
}
