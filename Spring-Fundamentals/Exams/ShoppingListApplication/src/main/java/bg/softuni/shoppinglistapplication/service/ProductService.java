package bg.softuni.shoppinglistapplication.service;

import bg.softuni.shoppinglistapplication.model.service.ProductServiceModel;
import bg.softuni.shoppinglistapplication.model.view.ProductHomeViewModel;

public interface ProductService {
    boolean createProduct(ProductServiceModel productServiceModel);

    ProductHomeViewModel findAllProductForHomePage();

    void buyProduct(String id);

    void buyAllProducts();

}
