package com.example.resellerapp.repository;

import com.example.resellerapp.model.entity.Offer;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer,String> {

    Optional<Offer> findById(String id);

}
