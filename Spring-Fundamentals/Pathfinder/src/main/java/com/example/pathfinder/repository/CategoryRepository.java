package com.example.pathfinder.repository;

import com.example.pathfinder.model.entity.CategoryEntity;
import com.example.pathfinder.model.entity.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

  Set<CategoryEntity> getByNameIn(Set<CategoryType> categories);

}
