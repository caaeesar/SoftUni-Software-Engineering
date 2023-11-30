package com.example.advancedquerying.repository;

import com.example.advancedquerying.entities.Ingredient;
import com.example.advancedquerying.entities.Shampoo;
import com.example.advancedquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> getShampoosBySizeOrderById(Size size);

    List<Shampoo> getShampoosBySizeOrLabelIdOrderByPriceAsc(Size size, Long id);

    List<Shampoo> getShampoosByPriceGreaterThanOrderByPriceDesc(double price);

    Long countShampoosByPriceLessThan(double price);

    @Query(""" 
            SELECT s
            FROM Shampoo AS s
            JOIN s.ingredients as i
            WHERE i.name IN :ingredientsName
            """)
    List<Shampoo> getShampoosByIngredientsName(List<String> ingredientsName);


    List<Shampoo> getShampoosByIngredientsIs(Ingredient ingredient);

    @Query("""
            SELECT s
            FROM Shampoo AS s
            WHERE size(s.ingredients) < :ingredientCount
            """)
    List<Shampoo> getShampoosByIngredientsCount(int ingredientCount);

}
