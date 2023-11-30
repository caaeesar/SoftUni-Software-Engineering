package bg.softuni.cardealer.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    private String make;
    private String model;
    @Column(name = "traveled_distance")
    private long travelledDistance;
    @ManyToMany
    @JoinTable(
            name = "parts_cars",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id")
    )
    private List<Part> parts;
}
