package com.example.mobilelelewebapplication.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

//    @GeneratedValue(generator = "uuid-string")
//    @GenericGenerator(name = "uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
//    private String id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
