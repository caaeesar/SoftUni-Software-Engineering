package bg.softuni.cardealer.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface CustomerService {
    void seedCustomers() throws JAXBException, FileNotFoundException;

    void getOrderedCustomers() throws JAXBException;

    void getTotalSalesByCustomer() throws JAXBException;
}
