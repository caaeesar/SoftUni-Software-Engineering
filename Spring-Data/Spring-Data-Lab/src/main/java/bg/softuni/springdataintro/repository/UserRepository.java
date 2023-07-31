package bg.softuni.springdataintro.repository;

import bg.softuni.springdataintro.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // basic CRUD methods from JPA Repository

    // can have custom methods:

    User getByUsername(String username);

}
