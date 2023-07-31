package bg.softuni.productshop.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface UserService {
    void seedUsers() throws JAXBException, FileNotFoundException;

    void findUsersWithSuccessfullySoldProducts() throws JAXBException;

    void findUsersAndProductsInfo() throws JAXBException;
}
