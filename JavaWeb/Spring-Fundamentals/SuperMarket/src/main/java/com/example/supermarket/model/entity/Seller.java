package com.example.supermarket.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sellers")
public class Seller extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2)
    private String firstName;

    @Column(nullable = false)
    @Size(min = 2)
    private String lastName;

    @Column(nullable = false)
    @Min(value = 18)
    private int age;

    @Column(nullable = false)
    @Positive
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.EAGER)
    private Shop shop;

    @ManyToOne()
    @JoinColumn(name = "manager_id")
    private Seller manager;

    public Seller(String firstName, String lastName, int age, BigDecimal salary, Shop shop) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.shop = shop;
    }
}
