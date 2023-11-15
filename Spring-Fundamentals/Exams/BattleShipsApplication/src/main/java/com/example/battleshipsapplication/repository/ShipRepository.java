package com.example.battleshipsapplication.repository;

import com.example.battleshipsapplication.model.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, String> {

    Optional<Ship> findShipByName(String name);

    @Query("SELECT s FROM Ship AS s ORDER BY s.name, s.health, s.power")
    List<Ship> findAllSorted();

    Ship findShipById(String id);

}
