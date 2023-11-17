package bg.softuni.andreysapplication.model.entity;

import bg.softuni.andreysapplication.model.entity.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "items")
@Getter
@Setter
public class Item extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 2)
    private String name;

    @Column(columnDefinition = "TEXT")
    @Size(min = 3)
    private String description;

    @Column
    @DecimalMin(value = "0")
    private BigDecimal price;

    @ManyToOne
    private Category category;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
