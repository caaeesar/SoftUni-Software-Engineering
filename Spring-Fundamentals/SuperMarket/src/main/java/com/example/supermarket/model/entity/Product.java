package com.example.supermarket.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name = "best_before")
    private LocalDate bestBefore;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    @Size(min = 2)
    private String name;

    @Column(nullable = false)
    @Positive
    private BigDecimal price;

    @ManyToOne
    private Category category;

   @ManyToMany(mappedBy = "products", targetEntity = Shop.class, fetch = FetchType.EAGER)
    private List<Shop> shops;

    public Product(LocalDate bestBefore, String name, BigDecimal price, Category category) {
        this.bestBefore = bestBefore;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
