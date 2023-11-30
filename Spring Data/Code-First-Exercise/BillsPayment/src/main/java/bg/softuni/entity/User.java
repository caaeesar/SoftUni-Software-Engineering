package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "owner", targetEntity = BillingDetail.class)
    private List<BillingDetail> billingDetails;


    public User() {

    }

    public User(String firstName, String password) {
        this.firstName = firstName;
        this.password = password;
        this.billingDetails = new ArrayList<>();
    }

}
