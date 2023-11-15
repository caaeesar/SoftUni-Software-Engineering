package com.example.battleshipsapplication.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "ships")
public class Ship extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 2, max = 10)
    private String name;

    @Column(nullable = false)
    private Integer health;

    @Column(nullable = false)
    private Integer power;

    @Column
    private LocalDate created;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User own;

}
