package bg.softuni.productsshop.service.impl;

import bg.softuni.productsshop.dao.CategoryRepository;
import bg.softuni.productsshop.model.dto.categoryDtos.CategorySeedDto;
import bg.softuni.productsshop.model.dto.categoryDtos.CategorySummaryDto;
import bg.softuni.productsshop.model.entity.Category;
import bg.softuni.productsshop.service.CategoryService;
import bg.softuni.productsshop.utils.JsonWriterUtil;
import bg.softuni.productsshop.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static bg.softuni.productsshop.constants.FilePaths.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepo, Gson gson, ModelMapper mapper, ValidationUtil validationUtil) {
        this.categoryRepo = categoryRepo;
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepo.count() > 0) {
            return;
        }

        String fileContend = Files.readString(Path.of(ROOT_IN_FILE_PATH + CATEGORIES_FILE_NAME));

        CategorySeedDto[] dtos = gson.fromJson(fileContend, CategorySeedDto[].class);

        Arrays.stream(dtos)
                .filter(this.validationUtil::isValid)
                .map(categorySeedDto -> this.mapper.map(categorySeedDto, Category.class))
                .forEach(this.categoryRepo::save);
    }

    @Override
    public void findCategoriesByProductsCount() throws IOException {
        List<CategorySummaryDto> dtos = this.categoryRepo.getCategoriesSummary();
        String jsonContent = this.gson.toJson(dtos);

        JsonWriterUtil.writeToJson(Collections.singletonList(jsonContent), Path.of(ROOT_OUT_FILE_PATH + CATEGORIES_BY_PRODUCTS_FILE_NAME));
    }
}
