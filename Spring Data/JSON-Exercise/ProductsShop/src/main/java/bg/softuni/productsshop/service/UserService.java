package bg.softuni.productsshop.service;

import java.io.IOException;

public interface UserService {
    void seedUsers() throws IOException;


    void findUsersWithSuccessfullySoldProducts() throws IOException;

    void findUsersAndProductsInfo() throws IOException;
}
