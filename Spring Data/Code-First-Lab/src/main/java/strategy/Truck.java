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
//@Table(name = "trucks")
@DiscriminatorValue(value = "Truck")
public class Truck extends Vehicle {
    // public static final String TYPE = "Truck";
    @Column(name = "load_capacity")
    private double loadCapacity;

    public Truck() {}
    public Truck(double loadCapacity) {
        //super(TYPE);
        this.loadCapacity = loadCapacity;
    }
}
