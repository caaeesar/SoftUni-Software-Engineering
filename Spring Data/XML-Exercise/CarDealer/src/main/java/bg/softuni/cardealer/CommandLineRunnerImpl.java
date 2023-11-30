package bg.softuni.cardealer;

import bg.softuni.cardealer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    @Autowired
    public CommandLineRunnerImpl(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Enter exercise number:");
        int exNumber = new Scanner(System.in).nextInt();
        switch (exNumber) {
            case 1 -> this.customerService.getOrderedCustomers();
            case 2 -> this.carService.getAllToyotaCars();
            case 3 -> this.supplierService.getSuppliersWhichNotImportedParts();
            case 4 -> this.carService.getCarsAndParts();
            case 5 -> this.customerService.getTotalSalesByCustomer();
            case 6 -> this.saleService.getSalesInfo();
        }
    }

    private void seedData() throws IOException, JAXBException {
        this.supplierService.seedSuppliers();
        this.partService.seedParts();
        this.carService.seedCars();
        this.customerService.seedCustomers();
        this.saleService.seedSales();
    }
}
