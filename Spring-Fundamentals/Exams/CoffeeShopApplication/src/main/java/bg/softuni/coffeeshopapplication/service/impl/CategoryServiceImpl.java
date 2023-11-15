package bg.softuni.coffeeshopapplication.service.impl;

import bg.softuni.coffeeshopapplication.model.entity.Category;
import bg.softuni.coffeeshopapplication.model.entity.enums.CategoryType;
import bg.softuni.coffeeshopapplication.repository.CategoryRepository;
import bg.softuni.coffeeshopapplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryType.values())
                .forEach(categoryType -> {
                    Category category = new Category();
                    category.setName(categoryType);
                    switch (categoryType) {
                        case Drink -> category.setNeededTime(1);
                        case Coffee -> category.setNeededTime(2);
                        case Other -> category.setNeededTime(5);
                        case Cake -> category.setNeededTime(10);
                    }
                    categoryRepository.save(category);
                });
    }
}
