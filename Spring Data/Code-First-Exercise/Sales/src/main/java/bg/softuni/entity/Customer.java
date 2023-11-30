package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "customers")
public class Customer extends BaseEntity {

    private String name;
    private String email;
    @Column(name = "credit_card_number")
    private String creditCardNumber;
    //bidirectional relation
    @OneToMany(mappedBy = "customer", targetEntity = Sale.class)
    private Set<Sale> sales;

}
