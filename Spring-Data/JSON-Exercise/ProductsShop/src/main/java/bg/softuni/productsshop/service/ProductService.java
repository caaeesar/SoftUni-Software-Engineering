package bg.softuni.productsshop.service;

import java.io.IOException;

public interface ProductService {

    void seedProducts() throws IOException;

    void findProductsInRange500To1000() throws IOException;


}
