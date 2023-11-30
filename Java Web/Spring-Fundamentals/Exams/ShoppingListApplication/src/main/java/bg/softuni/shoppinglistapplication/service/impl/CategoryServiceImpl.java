package bg.softuni.shoppinglistapplication.service.impl;

import bg.softuni.shoppinglistapplication.model.entity.Category;
import bg.softuni.shoppinglistapplication.model.entity.enums.CategoryName;
import bg.softuni.shoppinglistapplication.repository.CategoryRepository;
import bg.softuni.shoppinglistapplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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

        List<Category> categories = Arrays.stream(CategoryName.values()).map(categoryName -> {
            Category category = new Category();
            category.setName(categoryName);
            return category;
        }).toList();
        categoryRepository.saveAll(categories);
    }
}
