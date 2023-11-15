package com.example.resellerapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String description;

    @Column(nullable = false)
    @DecimalMin(value = "0")
    private BigDecimal price;

    @ManyToOne
    private Condition condition;

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private User boughtBy;

}
