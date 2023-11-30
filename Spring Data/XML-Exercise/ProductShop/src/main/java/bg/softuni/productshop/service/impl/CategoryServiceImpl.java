package bg.softuni.productshop.service.impl;

import bg.softuni.productshop.dao.CategoryRepository;
import bg.softuni.productshop.model.dto.exports.category.CategoryRootSummaryDto;
import bg.softuni.productshop.model.dto.exports.category.CategorySummaryDto;
import bg.softuni.productshop.model.dto.imports.CategoryRootSeedDto;
import bg.softuni.productshop.model.entity.Category;
import bg.softuni.productshop.service.CategoryService;
import bg.softuni.productshop.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

import static bg.softuni.productshop.constants.FilePaths.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper, XmlParser xmlParser) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCategories() throws JAXBException, FileNotFoundException {
        if (categoryRepository.count() > 0) {
            return;
        }
        CategoryRootSeedDto rootSeedDto = xmlParser.deserialize(CategoryRootSeedDto.class, ROOT_IN_FILE_PATH + CATEGORIES_FILE_NAME);
        rootSeedDto.getCategories().stream()
                .map(categorySeedDto -> mapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public void findCategoriesByProductsCount() throws JAXBException {
        List<CategorySummaryDto> categories = this.categoryRepository.getCategoriesSummary();
        CategoryRootSummaryDto rootSummaryDto = new CategoryRootSummaryDto();
        rootSummaryDto.setCategories(categories);
        xmlParser.serialize(rootSummaryDto, ROOT_OUT_FILE_PATH + CATEGORIES_BY_PRODUCTS_FILE_NAME);
    }
}
