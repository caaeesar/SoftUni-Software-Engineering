package bg.softuni.cardealer.service;

import java.io.IOException;

public interface SaleService {

    void seedSales();

    void getSalesInfo() throws IOException;
}
