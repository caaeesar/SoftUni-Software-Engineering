package strategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name = "bikes")
@DiscriminatorValue(value = "Bike")
public class Bike extends Vehicle {

    public Bike() {
        // super("Bike");
    }
}
