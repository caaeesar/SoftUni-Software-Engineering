package bg.softuni.cookingadventure.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingredients")
@Getter
@Setter
@NoArgsConstructor
public class IngredientEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    public IngredientEntity(String name) {
        this.name = name;
    }
}
