package bg.softuni.cardealer.service;

import javax.xml.bind.JAXBException;

public interface SaleService {
    void seedSales();

    void getSalesInfo() throws JAXBException;
}
