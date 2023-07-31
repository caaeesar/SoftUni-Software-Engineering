package strategy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
//@Table(name = "planes")
@DiscriminatorValue(value = "Plane")
public class Plane extends Vehicle {
    // public static final String TYPE = "Plane";
    @Column(name = "passenger_capacity")
    private int passengerCapacity;

    public Plane() {}

    public Plane(int passengerCapacity) {
        // super(TYPE);
        this.passengerCapacity = passengerCapacity;
    }
}
