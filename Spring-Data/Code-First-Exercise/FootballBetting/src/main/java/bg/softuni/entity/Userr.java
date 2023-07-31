package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "users")
public class Userr extends BaseEntity {

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique = true)
    private String email;
    @Column(name = "full_name")
    private String fullName;
    private BigDecimal balance = BigDecimal.ZERO;

    public Userr(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Userr() {

    }
}
