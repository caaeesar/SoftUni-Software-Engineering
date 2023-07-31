package bg.softuni.cardealer.service;

import java.io.IOException;

public interface SupplierService {
    void seedSuppliers() throws IOException;

    void getSuppliersWhichNotImportedParts() throws IOException;
}
