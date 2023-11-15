package com.example.supermarket.repository;

import com.example.supermarket.model.dto.SellerViewDto;
import com.example.supermarket.model.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {

    Shop getShopByName(String name);


}
