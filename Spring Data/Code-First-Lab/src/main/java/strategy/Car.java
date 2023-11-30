package strategy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
//@Table(name = "cars")
@DiscriminatorValue(value = "Car")
public class Car extends  Vehicle {
    // public static final String TYPE = "Car";
    @Basic
    private int seats;

    public Car() {

    }
    public Car(int seats) {
        // super(TYPE);
        this.seats = seats;
    }

}
