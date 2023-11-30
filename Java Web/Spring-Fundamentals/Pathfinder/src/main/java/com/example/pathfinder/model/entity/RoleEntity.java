package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity extends BaseEntity {

    @Column
    @Enumerated(value = EnumType.STRING)
    private UserRole name;

}
