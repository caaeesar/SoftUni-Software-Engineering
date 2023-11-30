package bg.softuni.productsshop.service;

import java.io.IOException;

public interface CategoryService {

    void seedCategories() throws IOException;

    void findCategoriesByProductsCount() throws IOException;
}
