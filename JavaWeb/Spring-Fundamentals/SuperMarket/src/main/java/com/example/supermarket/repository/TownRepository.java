package com.example.supermarket.repository;

import com.example.supermarket.model.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, String> {

    Town getTownByName(String name);
}
