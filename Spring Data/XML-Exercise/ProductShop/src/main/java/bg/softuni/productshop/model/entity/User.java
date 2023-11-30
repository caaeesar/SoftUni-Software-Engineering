package bg.softuni.productshop.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private int age;

    @ManyToMany
    @JoinTable(
            name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id")
    )
    private Set<User> friends;

    @OneToMany(mappedBy = "seller", targetEntity = Product.class, fetch = FetchType.EAGER)
    private List<Product> soldProducts;

    @OneToMany(mappedBy = "buyer", targetEntity = Product.class)
    private List<Product> boughtProducts;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public User() {
    }
    public String getFullName(){
        return this.firstName == null ? this.lastName : this.firstName + " " + this.lastName;
    }

}
