package bg.softuni.andreysapplication.model.service;

import bg.softuni.andreysapplication.model.entity.enums.CategoryName;
import bg.softuni.andreysapplication.model.entity.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemServiceModel {

    private String name;
    private String description;

    private CategoryName category;

    private Gender gender;

    private BigDecimal price;
}
