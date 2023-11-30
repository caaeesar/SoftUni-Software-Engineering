package com.example.mobilelelewebapplication.model.entity;

import com.example.mobilelelewebapplication.model.entity.enums.Engine;
import com.example.mobilelelewebapplication.model.entity.enums.Transmission;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
@Getter
@Setter
public class OfferEntity extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private Engine engine;

    @Column
    private String imageUrl;

    @Column
    private Integer mileage;

    @Column
    private BigDecimal price;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Transmission transmission;

    @Column
    private LocalDateTime created;

    @Column
    private Integer year;

    @Column
    private LocalDateTime modified;

    @ManyToOne // todo
    private ModelEntity model;

    @ManyToOne
    private UserEntity seller;

}
