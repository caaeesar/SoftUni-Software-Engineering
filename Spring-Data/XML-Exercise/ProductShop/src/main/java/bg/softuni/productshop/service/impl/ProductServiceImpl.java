package bg.softuni.productshop.service.impl;

import bg.softuni.productshop.dao.CategoryRepository;
import bg.softuni.productshop.dao.ProductRepository;
import bg.softuni.productshop.dao.UserRepository;
import bg.softuni.productshop.model.dto.exports.product.ProductInRangeDto;
import bg.softuni.productshop.model.dto.exports.product.ProductRootInRangeDto;
import bg.softuni.productshop.model.dto.imports.ProductRootSeedDto;
import bg.softuni.productshop.model.entity.Category;
import bg.softuni.productshop.model.entity.Product;
import bg.softuni.productshop.model.entity.User;
import bg.softuni.productshop.service.ProductService;
import bg.softuni.productshop.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static bg.softuni.productshop.constants.FilePaths.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository, ModelMapper mapper, XmlParser xmlParser) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedProducts() throws JAXBException, FileNotFoundException {
        if (productRepository.count() > 0) {
            return;
        }
        ProductRootSeedDto rootSeedDto = xmlParser.deserialize(ProductRootSeedDto.class, ROOT_IN_FILE_PATH + PRODUCTS_FILE_NAME);
        List<Product> products = rootSeedDto.getProducts().stream()
                .map(productSeedDto -> mapper.map(productSeedDto, Product.class))
                .toList();

        long usersRepoSize = userRepository.count();
        long categoriesRepoSize = categoryRepository.count();
        // randomly select the buyer and seller from the existing users
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            product.setBuyer(getRandomUser(usersRepoSize));
            product.setSeller(getRandomUser(usersRepoSize));
            product.setCategories(Set.of(getRandomCategory(categoriesRepoSize)));
            productRepository.save(product);
        }
    }

    @Override
    public void findProductsInRange500To1000() throws JAXBException {
        List<Product> products = this.productRepository.getProductsByPriceBetweenOrderByPriceAsc(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
        List<ProductInRangeDto> productInRangeDtos = products.stream()
                .map(product -> {
                    ProductInRangeDto productInRangeDto = mapper.map(product, ProductInRangeDto.class);
                    productInRangeDto.setSeller(product.getSeller().getFullName());
                    return productInRangeDto;
                })
                .toList();
        ProductRootInRangeDto rootInRangeDto = new ProductRootInRangeDto();
        rootInRangeDto.setProducts(productInRangeDtos);
        xmlParser.serialize(rootInRangeDto, ROOT_OUT_FILE_PATH + PRODUCTS_IN_RANGE_FILE_NAME);
    }

    private Category getRandomCategory(long upperBound) {
        Random random = new Random();
        long randomId = random.nextLong(upperBound) + 1;
        return categoryRepository.findById(randomId).get();
    }

    private User getRandomUser(long upperBound) {
        Random random = new Random();
        long randomId = random.nextLong(upperBound) + 1;
        return userRepository.findById(randomId).get();
    }
}
