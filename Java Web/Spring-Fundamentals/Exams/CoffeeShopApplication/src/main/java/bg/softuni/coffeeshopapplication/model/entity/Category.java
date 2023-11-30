package bg.softuni.coffeeshopapplication.model.entity;

import bg.softuni.coffeeshopapplication.model.entity.enums.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter@NoArgsConstructor
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column
    @Enumerated(value = EnumType.STRING)
    private CategoryType name;

    @Column(name = "needed_time", nullable = false)
    private Integer neededTime;
}
