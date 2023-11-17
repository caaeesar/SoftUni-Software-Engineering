package com.example.mobilelelewebapplication.model.entity;

import com.example.mobilelelewebapplication.model.entity.enums.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class RoleEntity extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private RoleType name;

    public RoleEntity(RoleType name) {
        this.name = name;
    }

}
