package com.example.advancedquerying.service;

import com.example.advancedquerying.entities.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> selectIngredientsByName(char letter);

    List<Ingredient> selectIngredientByNames(List<String> ingredientNames);

    void deleteIngredientsByName(String name);

    Ingredient getIngredientByName(String name);

    void updateIngredientsPriceBy10Percent();

    int updatePriceOfIngredientsInList(double percent, List<String> ingredientNames);

}
