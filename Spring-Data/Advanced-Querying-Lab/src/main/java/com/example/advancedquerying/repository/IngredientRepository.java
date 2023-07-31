package com.example.advancedquerying.repository;

import com.example.advancedquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> getIngredientsByNameStartingWith(char letter);

    List<Ingredient> getIngredientsByNameInOrderByPriceAsc(List<String> names);

    Ingredient getIngredientByName(String name);

    @Transactional
    void deleteIngredientByName(String name);

    @Modifying
    @Query("""
            UPDATE Ingredient AS i
            SET i.price = i.price * :p
           """)
    void updatePriceOfIngredients(@Param("p") double percent);

    @Modifying
    @Query("""
            UPDATE Ingredient AS i
            SET i.price = i.price * :p
            WHERE i.name IN (:iNames)
           """)
    int updatePriceOfIngredientsInList(@Param("p") double percent,
                                        @Param("iNames") List<String> ingredientNames);

}
