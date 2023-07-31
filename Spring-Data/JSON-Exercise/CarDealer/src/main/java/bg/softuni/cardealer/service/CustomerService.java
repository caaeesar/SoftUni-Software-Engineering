package bg.softuni.cardealer.service;

import java.io.IOException;

public interface CustomerService {

    void seedCustomers() throws IOException;

    void getOrderedCustomers() throws IOException;

    void getTotalSalesByCustomer() throws IOException;
}
