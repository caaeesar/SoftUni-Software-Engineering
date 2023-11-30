package bg.softuni.shoppinglistapplication.service.impl;

import bg.softuni.shoppinglistapplication.model.entity.Category;
import bg.softuni.shoppinglistapplication.model.entity.Product;
import bg.softuni.shoppinglistapplication.model.entity.enums.CategoryName;
import bg.softuni.shoppinglistapplication.model.service.ProductServiceModel;
import bg.softuni.shoppinglistapplication.model.view.*;
import bg.softuni.shoppinglistapplication.repository.CategoryRepository;
import bg.softuni.shoppinglistapplication.repository.ProductRepository;
import bg.softuni.shoppinglistapplication.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean createProduct(ProductServiceModel productServiceModel) {
        Optional<Product> optionalProduct = productRepository.findByName(productServiceModel.getName());
        if (optionalProduct.isPresent()) {
            return false;
        }

        Product product = modelMapper.map(productServiceModel, Product.class);
        Category category = categoryRepository.getCategoryByName(productServiceModel.getCategory());
        product.setCategory(category);
        productRepository.save(product);
        return true;
    }

    @Override
    public ProductHomeViewModel findAllProductForHomePage() {
        ProductHomeViewModel productHomeViewModel = new ProductHomeViewModel();
        productHomeViewModel.setTotalPrice(productRepository.getTotalPrice());

        List<ProductsFoodViewModel> productsFood = productRepository.findProductByCategory_Name(CategoryName.FOOD)
                .stream()
                .map(product -> modelMapper.map(product, ProductsFoodViewModel.class))
                .toList();
        productHomeViewModel.setProductsFood(productsFood);

        List<ProductsDrinkViewModel> productsDrink = productRepository.findProductByCategory_Name(CategoryName.DRINK)
                .stream()
                .map(product -> modelMapper.map(product, ProductsDrinkViewModel.class))
                .toList();
        productHomeViewModel.setProductsDrink(productsDrink);

        List<ProductsHouseholdViewModel> productsHousehold = productRepository.findProductByCategory_Name(CategoryName.HOUSEHOLD)
                .stream()
                .map(product -> modelMapper.map(product, ProductsHouseholdViewModel.class))
                .toList();
        productHomeViewModel.setProductsHousehold(productsHousehold);

        List<ProductOtherViewModel> productOther = productRepository.findProductByCategory_Name(CategoryName.OTHER)
                .stream()
                .map(product -> modelMapper.map(product, ProductOtherViewModel.class))
                .toList();
        productHomeViewModel.setProductOther(productOther);

        return productHomeViewModel;
    }

    @Override
    public void buyProduct(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAllProducts() {
        productRepository.deleteAll();
    }
}
