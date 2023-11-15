package com.example.battleshipsapplication.model.entity;

import com.example.battleshipsapplication.model.entity.enums.CategoryName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category extends BaseEntity {

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false, unique = true)
    private CategoryName name;

    @Column(columnDefinition = "TEXT")
    private String description;

}
