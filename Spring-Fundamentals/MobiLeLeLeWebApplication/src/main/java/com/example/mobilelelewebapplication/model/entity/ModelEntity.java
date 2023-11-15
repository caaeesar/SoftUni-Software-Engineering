package com.example.mobilelelewebapplication.model.entity;

import com.example.mobilelelewebapplication.model.entity.enums.Category;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
@Table(name = "models")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ModelEntity extends BaseEntity {

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @NonNull
    @Column
    @Length(min = 8, max =  512)
    private String imageUrl;

    @NonNull
    @Column
    private Integer startYear;

    @Column
    private Integer endYear;

    @NonNull
    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @ManyToOne
    private BrandEntity brand;

    public ModelEntity() {

    }
}
