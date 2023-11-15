package bg.softuni.shoppinglistapplication.model.entity;

import bg.softuni.shoppinglistapplication.model.entity.enums.CategoryName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(value = EnumType.STRING)
    private CategoryName name;

    @Column
    private String description;
}
