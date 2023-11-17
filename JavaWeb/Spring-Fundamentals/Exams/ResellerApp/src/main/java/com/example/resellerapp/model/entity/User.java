package com.example.resellerapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 20)
    private String username;

    @Column(nullable = false)
   // @Size(min = 3, max = 20)
    private String password;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @OneToMany(mappedBy = "createdBy", targetEntity = Offer.class)
    private Set<Offer> offers;

    @OneToMany(mappedBy = "boughtBy", targetEntity = Offer.class)
    private Set<Offer> boughtOffers;

    public User() {
        offers = new HashSet<>();
        boughtOffers = new HashSet<>();
    }
}
