package com.example.resellerapp.model.entity;

import com.example.resellerapp.model.entity.enums.ConditionName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "conditions")
public class Condition extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ConditionName name;

    @Column(nullable = false)
    private String description;

}
