package com.example.supermarket.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Size(min = 2, message = "Name must be minimum two characters!")
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
