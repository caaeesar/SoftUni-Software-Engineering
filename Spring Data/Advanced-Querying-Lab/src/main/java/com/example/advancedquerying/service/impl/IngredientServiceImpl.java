package com.example.advancedquerying.service.impl;

import com.example.advancedquerying.entities.Ingredient;
import com.example.advancedquerying.repository.IngredientRepository;
import com.example.advancedquerying.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public List<Ingredient> selectIngredientsByName(char letter) {
        return this.ingredientRepo.getIngredientsByNameStartingWith(letter);
    }

    @Override
    public List<Ingredient> selectIngredientByNames(List<String> ingredientNames) {
        return this.ingredientRepo.getIngredientsByNameInOrderByPriceAsc(ingredientNames);
    }

    @Override
    public void deleteIngredientsByName(String name) {
         this.ingredientRepo.deleteIngredientByName(name);
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        return this.ingredientRepo.getIngredientByName(name);
    }

    @Override
    public void updateIngredientsPriceBy10Percent() {
        this.ingredientRepo.updatePriceOfIngredients(1.1);
    }

    @Override
    public int updatePriceOfIngredientsInList(double percent, List<String> ingredientNames) {
        return this.ingredientRepo.updatePriceOfIngredientsInList(percent, ingredientNames);
    }
}
