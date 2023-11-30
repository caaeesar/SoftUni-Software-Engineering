package bg.softuni.usersystem.repository;

import bg.softuni.usersystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getUsersByEmailEndsWith(String emailProvider);
    List<User> getUsersByLastTimeLoggedInBefore(LocalDate dateAfter);
}
