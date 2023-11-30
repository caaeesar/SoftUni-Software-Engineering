package relations.OneToOne;

import lombok.Getter;
import lombok.Setter;
import strategy.Car;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "plate_numbers")
public class PlateNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String number;
    // bidirectional relation
              // field in pojo class MyCar
    @OneToOne(mappedBy = "plateNumber", targetEntity = MyCar.class)
    private Car car;
}
