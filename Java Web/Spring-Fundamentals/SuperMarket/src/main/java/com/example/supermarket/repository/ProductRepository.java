package com.example.supermarket.repository;

import com.example.supermarket.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Product getProductByName(String name);
}
