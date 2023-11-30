package bg.softuni.productsshop.service.impl;

import bg.softuni.productsshop.dao.CategoryRepository;
import bg.softuni.productsshop.dao.ProductRepository;
import bg.softuni.productsshop.dao.UserRepository;
import bg.softuni.productsshop.model.dto.productDtos.ProductInRangeDto;
import bg.softuni.productsshop.model.dto.productDtos.ProductSeedDto;
import bg.softuni.productsshop.model.entity.Category;
import bg.softuni.productsshop.model.entity.Product;
import bg.softuni.productsshop.model.entity.User;
import bg.softuni.productsshop.service.ProductService;
import bg.softuni.productsshop.utils.JsonWriterUtil;
import bg.softuni.productsshop.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static bg.softuni.productsshop.constants.FilePaths.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;
    private final UserRepository userRepo;
    private final ValidationUtil validationUtil;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepo, CategoryRepository categoryRepo, UserRepository userRepo, ValidationUtil validationUtil, ModelMapper mapper, Gson gson) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
        this.userRepo = userRepo;
        this.validationUtil = validationUtil;
        this.mapper = mapper;
        this.gson = gson;
    }

    @Override
    public void seedProducts() throws IOException {
        if (this.productRepo.count() > 0) {
            return;
        }

        String fileContent = Files.readString(Path.of(ROOT_IN_FILE_PATH + PRODUCTS_FILE_NAME));

        ProductSeedDto[] dtos = this.gson.fromJson(fileContent, ProductSeedDto[].class);

        List<Product> products = Arrays.stream(dtos)
                .filter(this.validationUtil::isValid)
                .map(productSeedDto -> this.mapper.map(productSeedDto, Product.class))
                .toList();

        long usersRepoSize = this.userRepo.count();
        long categoriesRepoSize = this.categoryRepo.count();
        // randomly select the buyer and seller from the existing users
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            product.setBuyer(getRandomUser(usersRepoSize));
            product.setSeller(getRandomUser(usersRepoSize));
            product.setCategories(Set.of(getRandomCategory(categoriesRepoSize)));
            this.productRepo.save(product);
        }
    }

    @Override
    public void findProductsInRange500To1000() throws IOException {
        List<Product> products = this.productRepo.getProductsByPriceBetweenOrderByPriceAsc(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
        // custom mapping
        TypeMap<Product, ProductInRangeDto> typeMap = this.mapper.createTypeMap(Product.class, ProductInRangeDto.class)
                .addMappings(mapping -> mapping.map(source -> source.getSeller().getFullName(), ProductInRangeDto::setSeller));
        List<ProductInRangeDto> dtos = products.stream()
                .map(typeMap::map)
                .toList();

        String content = this.gson.toJson(dtos);
        JsonWriterUtil.writeToJson(Collections.singletonList(content), Path.of(ROOT_OUT_FILE_PATH + PRODUCTS_IN_RANGE_FILE_NAME));
    }

    private Category getRandomCategory(long upperBound) {
        Random random = new Random();
        long randomId = random.nextLong(upperBound) + 1;
        return this.categoryRepo.findById(randomId).get();
    }

    private User getRandomUser(long upperBound) {
        Random random = new Random();
        long randomId = random.nextLong(upperBound) + 1;
        return this.userRepo.findById(randomId).get();
    }

}
