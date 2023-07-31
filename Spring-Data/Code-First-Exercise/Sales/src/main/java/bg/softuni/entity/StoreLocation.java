package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "stores_location")
public class StoreLocation extends BaseEntity {

    @Column(name = "location_name")
    private String locationName;
    // bidirectional relation
    @OneToMany(mappedBy = "storeLocation", targetEntity = Sale.class)
    private Set<Sale> sales;
}
