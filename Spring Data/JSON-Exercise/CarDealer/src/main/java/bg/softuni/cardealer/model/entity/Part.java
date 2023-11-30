package bg.softuni.cardealer.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "parts")
public class Part extends BaseEntity {

    private String name;
    private BigDecimal price;
    private long quantity;
    @ManyToOne
    private Supplier supplier;
    @ManyToMany(mappedBy = "parts", targetEntity = Car.class)
    @Fetch(FetchMode.JOIN)
    private List<Car> cars;


}
