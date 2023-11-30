package bg.softuni.bookshopsystem.service.impl;

import bg.softuni.bookshopsystem.entity.Category;
import bg.softuni.bookshopsystem.repository.CategoryRepository;
import bg.softuni.bookshopsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;

import static bg.softuni.bookshopsystem.constants.FilePath.CATEGORIES_FILE_NAME;
import static bg.softuni.bookshopsystem.constants.FilePath.ROOT_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public boolean isDataSeeded() {
        return this.categoryRepo.count() > 0;
    }

    @Override
    public void seedCategories() throws IOException {
        if (isDataSeeded()) {
            return;
        }

        Files.readAllLines(Path.of(ROOT_PATH + CATEGORIES_FILE_NAME))
                .stream().filter(line -> !line.isBlank())
                .forEach(line -> {
                    Category category = new Category(line);
                    this.categoryRepo.save(category);
                });
    }
}
