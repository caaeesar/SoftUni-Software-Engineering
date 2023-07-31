package relations.OneToMany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "aircrafts")
@Setter
@Getter
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String airLine;

    // many aircraft can have a company
    @ManyToOne // FK in aircrafts table
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

}
