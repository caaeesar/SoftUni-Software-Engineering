package com.example.advancedquerying.service;

import com.example.advancedquerying.entities.Ingredient;
import com.example.advancedquerying.entities.Shampoo;
import com.example.advancedquerying.entities.Size;

import java.util.List;

public interface ShampooService {

    List<Shampoo> selectShampoosBySize(Size size);
    List<Shampoo> selectShampooBySizeOrLabel(Size size, Long id);

    List<Shampoo> selectShampooByPrice(double price);

    Long countShampoosByPrice(double price);

    List<Shampoo> selectShampoosByIngredients(List<String> ingredientsName);
    List<Shampoo> selectShampoosByIngredient(Ingredient ingredient);

    List<Shampoo> selectShampoosByIngredientsCount(int ingredientCount);


}
