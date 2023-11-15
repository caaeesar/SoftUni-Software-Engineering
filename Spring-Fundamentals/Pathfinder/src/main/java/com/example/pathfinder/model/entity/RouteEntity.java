package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.RouteLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "routes")
public class RouteEntity extends BaseEntity {

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    @Enumerated(value = EnumType.STRING)
    private RouteLevel level;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity author;

    @Column(name = "video_url", columnDefinition = "TEXT")
    private String videoUrl;

    @ManyToMany
    @JoinTable(
            name = "routes_categories",
            joinColumns = @JoinColumn(name = "route_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private Set<CategoryEntity> categories = new HashSet<>();

}
