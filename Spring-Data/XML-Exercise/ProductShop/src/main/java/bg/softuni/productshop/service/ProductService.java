package bg.softuni.productshop.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface ProductService {
    void seedProducts() throws JAXBException, FileNotFoundException;
    void findProductsInRange500To1000() throws JAXBException;
}
