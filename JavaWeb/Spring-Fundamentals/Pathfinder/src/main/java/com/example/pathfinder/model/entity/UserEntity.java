package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.UserLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity extends BaseEntity {

    @Column
    @Size(min = 2)
    private String username;

    @Column
    @Size(min = 2)
    private String password;

    @Column(name = "full_name")
    @Size(min = 2)
    private String fullName;

    @Column
    @Positive
    private Integer age;

    @Column
    @Email(regexp = ".+@.+")
    private String email;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<RoleEntity> roles;

    @Column
    @Enumerated(value = EnumType.STRING)
    private UserLevel level;

}
