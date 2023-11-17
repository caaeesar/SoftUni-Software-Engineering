package bg.softuni.andreysapplication.service.impl;

import bg.softuni.andreysapplication.model.entity.Category;
import bg.softuni.andreysapplication.model.entity.enums.CategoryName;
import bg.softuni.andreysapplication.repository.CategoryRepository;
import bg.softuni.andreysapplication.service.CategoryService;
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

        List<Category> categories = Arrays.stream(CategoryName.values()).map(Category::new).toList();
        categoryRepository.saveAll(categories);
    }
}
