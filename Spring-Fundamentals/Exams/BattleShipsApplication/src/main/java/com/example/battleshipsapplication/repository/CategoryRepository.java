package com.example.battleshipsapplication.repository;

import com.example.battleshipsapplication.model.entity.Category;
import com.example.battleshipsapplication.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Category getCategoryByName(CategoryName name);

}
