package relations.OneToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Setter
@Getter
public class MyCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fuel_type")
    private String fuelType;
    @Basic
    private String model;
    @Column(columnDefinition = "DECIMAL(19,2)")
    private double price;
    @Basic
    private String type;
    @Basic
    private int seats;

    @OneToOne  // column in cars table
    @JoinColumn(name = "plate_number_id", referencedColumnName = "id")
    PlateNumber plateNumber;              // plateNumber id
}
