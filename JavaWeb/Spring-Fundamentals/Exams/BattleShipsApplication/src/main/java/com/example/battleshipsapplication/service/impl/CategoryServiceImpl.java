package com.example.battleshipsapplication.service.impl;

import com.example.battleshipsapplication.model.entity.Category;
import com.example.battleshipsapplication.model.entity.enums.CategoryName;
import com.example.battleshipsapplication.repository.CategoryRepository;
import com.example.battleshipsapplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void seedCategory() {
        if (categoryRepository.count() != 0) {
            return;
        }

        List<Category> categories = Arrays.stream(CategoryName.values()).map(categoryName -> {
            Category category = new Category();
            category.setName(categoryName);
            return category;
        }).collect(Collectors.toList());

        categoryRepository.saveAll(categories);
    }
}
