package bg.softuni.andreysapplication.model.binding;

import bg.softuni.andreysapplication.model.entity.enums.CategoryName;
import bg.softuni.andreysapplication.model.entity.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemAddBindingModel {

    @NotBlank
    @Length(min = 2, message = "Username length must be more than two characters\n")
    private String name;

    @Length(min = 3, message = "Description length must be more than three characters")
    private String description;

    @NotNull(message = "Category cannot be empty")
    private CategoryName category;

    @NotNull(message = "Gender cannot be empty")
    private Gender gender;

    @Positive(message = "Price must be positive number\n")
    private BigDecimal price;

}
