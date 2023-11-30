package bg.softuni.springdataintro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private int age;

    @OneToMany(mappedBy = "user", targetEntity = Account.class)
    private Set<Account> accounts;

    public User(String username) {
        this.username = username;
    }
}
