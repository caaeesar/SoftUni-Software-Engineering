package bg.softuni.andreysapplication.model.entity;

import bg.softuni.andreysapplication.model.entity.enums.CategoryName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryName name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category(CategoryName name) {
        this.name = name;
    }
}
