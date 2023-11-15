package com.example.supermarket.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "towns")
public class Town extends BaseEntity {

    @Column
    private String name;

    public Town(String name) {
        this.name = name;
    }
}
