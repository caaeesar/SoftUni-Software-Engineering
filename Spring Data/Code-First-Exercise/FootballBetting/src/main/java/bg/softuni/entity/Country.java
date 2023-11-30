package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "countries")
public class Country {

    @Id
    @Column(nullable = false, length = 3)
    private String id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "countries_continents",
            joinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id")
    )
    private Set<Continent> continents;

    @OneToMany(mappedBy = "country", targetEntity = Town.class)
    private List<Town> towns;

    public Country(String id) {
        this.id = id;
        this.towns = new ArrayList<>();
    }

    public Country() {

    }
}
