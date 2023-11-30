package bg.softuni.cardealer.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    private String name;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "is_young_driver")
    private boolean isYoungDriver;

    @OneToMany(mappedBy = "customer", targetEntity = Sale.class)
    // automatically generated JPQL query:
    // @Query("SELECT c FROM Customer c JOIN FETCH c.sales")
    @Fetch(FetchMode.JOIN)
    private List<Sale> sales;

}
