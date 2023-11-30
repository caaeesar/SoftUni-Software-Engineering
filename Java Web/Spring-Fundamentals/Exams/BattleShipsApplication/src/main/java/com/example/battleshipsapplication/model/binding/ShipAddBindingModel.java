package com.example.battleshipsapplication.model.binding;

import com.example.battleshipsapplication.model.entity.enums.CategoryName;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ShipAddBindingModel {

    @NotBlank
    @NotEmpty
    @NotNull
    @Length(min = 2, max = 10)
    private String name;

    @NotNull
    @Positive
    private Integer power;

    @NotNull
    @Positive
    private Integer health;

    @DateTimeFormat(pattern = "YY/MM/DD")
    @PastOrPresent
    private LocalDate created;

    @NotNull
    private CategoryName category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }
}
