package relations.OneToMany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Setter
@Getter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // bidirectional relation
    // не създаваме нова връзка, а указваме че вече има съществуваща
    @OneToMany(mappedBy = "company", targetEntity = Aircraft.class)
    private List<Aircraft> aircrafts;

    public Company() {
        this.aircrafts = new ArrayList<>();
    }
}
