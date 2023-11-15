package com.example.mobilelelewebapplication.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "brands")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class BrandEntity extends BaseEntity {

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @OneToMany(mappedBy = "brand", targetEntity = ModelEntity.class, fetch = FetchType.EAGER)
    private List<ModelEntity> models;


    public BrandEntity() {

    }
}
