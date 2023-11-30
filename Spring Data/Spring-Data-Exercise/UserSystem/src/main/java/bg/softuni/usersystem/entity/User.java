package bg.softuni.usersystem.entity;

import bg.softuni.usersystem.annotation.email.Email;
import bg.softuni.usersystem.annotation.password.Password;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false)
    @Length(min = 4, max = 30)
    private String username;

    @Password(maxLength = 40,
            containsDigit = true,
            containsLowerCase = true,
            containsUpperCase = true,
            containsSpecialSymbols = true)
    private String password;

    @Email(minUserLength = 3, minHostLength = 3)
    private String email;

    @Column(name = "registration_od")
    private LocalDate registrationOn;

    @Column(name = "lastTimeLoggedIn")
    private LocalDate lastTimeLoggedIn;

    private int age;

    @Column(name = "is_deleted", columnDefinition = "TINYINT(1)")
    private boolean isDeleted;

    @ManyToOne
    private Town bornTown;

    @ManyToOne
    private Town currentTown;

    @ManyToMany
    @JoinColumn(name = "friend_id", referencedColumnName = "id")
    private List<User> friends;

    @OneToMany
    private List<Album> albums;

    public String getFullName() {
        return this.firstName  + " " + this.lastName;
    }

}
