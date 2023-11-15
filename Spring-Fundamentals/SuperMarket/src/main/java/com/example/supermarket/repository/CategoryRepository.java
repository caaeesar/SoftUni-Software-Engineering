package com.example.supermarket.repository;

import com.example.supermarket.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Category getCategoryByName(String name);
}
