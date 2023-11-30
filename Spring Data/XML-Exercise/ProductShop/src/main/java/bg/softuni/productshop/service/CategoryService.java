package bg.softuni.productshop.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface CategoryService {
    void seedCategories() throws JAXBException, FileNotFoundException;

    void findCategoriesByProductsCount() throws JAXBException;
}
