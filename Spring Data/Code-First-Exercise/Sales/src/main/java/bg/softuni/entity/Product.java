package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "products")
public class Product extends BaseEntity{

    private String name;
    private double quantity;
    private BigDecimal price;
    // bidirectional relation
    @OneToMany(mappedBy = "product", targetEntity = Sale.class)
    private Set<Sale> sales;

}
