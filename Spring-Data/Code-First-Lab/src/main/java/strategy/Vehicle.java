package strategy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "vehicles")
@DiscriminatorColumn(name = "type")
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(insertable = false, updatable = false)
    private String type;
    @Basic
    private String model;
    @Column(columnDefinition = "DECIMAL(19,2)")
    private BigDecimal price = new BigDecimal(0);
    @Column(name = "fuel_type")
    private String fuelType;

    protected Vehicle(){}

    /*protected Vehicle(String type) {
        this.type = type;
    }*/
}
