package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "towns")
public class Town extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @OneToMany(mappedBy = "residentTown", targetEntity = Team.class) // bidirectional relation
    private List<Team> teams;

    public Town(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
    }

    public Town() {

    }
}
