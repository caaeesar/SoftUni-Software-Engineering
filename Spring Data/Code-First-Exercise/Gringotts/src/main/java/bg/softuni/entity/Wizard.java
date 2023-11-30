package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wizards")
@Setter
@Getter
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;
    @Column(length = 1000)
    private String notes;
    @Column(nullable = false)
    private int age;

    // one wizard to one magicWand
    @OneToOne
    private MagicWand magicWand;

    // one wizard (current class) to many deposits
    // unidirectional relation
    @OneToMany
    @JoinTable(
            name = "wizards_deposits",
            joinColumns = @JoinColumn(name = "wizard_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "deposit_id", referencedColumnName = "id")
    )
    private List<Deposit> deposits;

    public Wizard() {}

    public Wizard(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
        this.deposits = new ArrayList<>();
    }
}
