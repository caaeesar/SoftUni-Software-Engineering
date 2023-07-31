package com.example.advancedquerying.service.impl;

import com.example.advancedquerying.entities.Ingredient;
import com.example.advancedquerying.entities.Shampoo;
import com.example.advancedquerying.entities.Size;
import com.example.advancedquerying.repository.ShampooRepository;
import com.example.advancedquerying.service.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {

    private ShampooRepository shampooRepo;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepo) {
        this.shampooRepo = shampooRepo;
    }

    @Override
    public List<Shampoo> selectShampoosBySize(Size size) {
       return this.shampooRepo.getShampoosBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> selectShampooBySizeOrLabel(Size size, Long id) {
        return this.shampooRepo.getShampoosBySizeOrLabelIdOrderByPriceAsc(size, id);
    }

    @Override
    public List<Shampoo> selectShampooByPrice(double price) {
        return this.shampooRepo.getShampoosByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public Long countShampoosByPrice(double price) {
        return this.shampooRepo.countShampoosByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> selectShampoosByIngredients(List<String> ingredientsName) {
        return this.shampooRepo.getShampoosByIngredientsName(ingredientsName);
    }

    @Override
    public List<Shampoo> selectShampoosByIngredient(Ingredient ingredient) {
        return this.shampooRepo.getShampoosByIngredientsIs(ingredient);
    }

    @Override
    public List<Shampoo> selectShampoosByIngredientsCount(int ingredientCount) {
        return this.shampooRepo.getShampoosByIngredientsCount(ingredientCount);
    }
}
