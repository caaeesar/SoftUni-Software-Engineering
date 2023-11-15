package bg.softuni.shoppinglistapplication.model.binding;

import bg.softuni.shoppinglistapplication.model.entity.enums.CategoryName;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    @NotBlank
    @Length(min = 3, max = 20, message = "Name length must be between 3 and 20 characters")
    private String name;

    @Length(min = 5, message = "Description min length must be minimum 5(inclusive) characters")
    private String description;

    @Positive(message = "Price must be a positive number")
    private BigDecimal price;

    @DateTimeFormat(pattern = "YY.MM.DD hh:mm:ss")
    @FutureOrPresent(message = "Cannot be in the past")
    private LocalDateTime neededBefore;

    @NotNull(message = "You must select category")
    private CategoryName category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
    }

    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }
}
