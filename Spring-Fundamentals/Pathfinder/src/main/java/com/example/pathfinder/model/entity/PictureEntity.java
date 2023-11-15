package com.example.pathfinder.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pictures")
public class PictureEntity extends BaseEntity {

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private RouteEntity route;
}
