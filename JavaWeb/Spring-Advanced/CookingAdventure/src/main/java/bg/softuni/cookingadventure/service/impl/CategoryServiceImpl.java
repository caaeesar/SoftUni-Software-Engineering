package bg.softuni.cookingadventure.service.impl;

import bg.softuni.cookingadventure.model.entity.CategoryEntity;
import bg.softuni.cookingadventure.model.entity.enums.CategoryName;
import bg.softuni.cookingadventure.repository.CategoryRepository;
import bg.softuni.cookingadventure.service.CategoryService;
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
    public void seedCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }

        List<CategoryEntity> categories = Arrays.stream(CategoryName.values()).map(CategoryEntity::new).collect(Collectors.toList());
        categoryRepository.saveAll(categories);
    }
}
