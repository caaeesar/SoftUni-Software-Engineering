package bg.softuni.coffeeshopapplication.model.binding;

import bg.softuni.coffeeshopapplication.model.entity.Category;
import bg.softuni.coffeeshopapplication.model.entity.enums.CategoryType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddBindingModel {

    @NotEmpty
    @NotNull
    @Length(min = 3, max = 20)
    private String name;

    @Positive
    @NotNull
    private BigDecimal price;

    @DateTimeFormat(pattern = "YY-MM-DD hh:mm:ss")
    @PastOrPresent
    @NotNull
    private LocalDateTime orderTime;

    @NotNull
    private CategoryType category;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
