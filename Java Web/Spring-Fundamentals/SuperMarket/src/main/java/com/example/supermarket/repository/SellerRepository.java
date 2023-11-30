package com.example.supermarket.repository;

import com.example.supermarket.model.dto.SellerViewDto;
import com.example.supermarket.model.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SellerRepository extends JpaRepository<Seller, String> {

    Seller getSellerByFirstNameAndLastName(String firstName, String lastName);

    Set<Seller> getSellersByShop_NameOrderByFirstNameAsc(String name);
}
