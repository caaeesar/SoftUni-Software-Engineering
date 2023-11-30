package bg.softuni.cardealer.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "sales")
public class Sale extends BaseEntity {

    @OneToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    private double discount;

    public Sale(Car car, Customer customer, double discount) {
        this.car = car;
        this.customer = customer;
        this.discount = discount;
    }
}
