package com.example.battleshipsapplication.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends BaseEntity {


    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 10)
    private String username;

    @Column(name = "full_name", nullable = false)
    @Size(min = 5, max = 20)
    private String fullName;

    @Column(nullable = false)
    @Size(min = 3)
    private String password;

    @Column(nullable = false)
    private String email;

}
