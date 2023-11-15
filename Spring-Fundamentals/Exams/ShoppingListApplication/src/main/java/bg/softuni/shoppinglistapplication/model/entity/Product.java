package bg.softuni.shoppinglistapplication.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 20)
    private String name;

    @Column
    @Size(min = 5)
    private String description;

    @Column
    private BigDecimal price;

    @Column(name = "needed_before")
    private LocalDateTime neededBefore;

    @ManyToOne
    private Category category;
}
