package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column
    @Enumerated(value = EnumType.STRING)
    private CategoryType name;

    @Column(columnDefinition = "TEXT")
    private String description;

}
