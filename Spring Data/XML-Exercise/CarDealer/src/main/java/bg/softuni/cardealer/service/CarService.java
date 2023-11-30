package bg.softuni.cardealer.service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface CarService {
    void seedCars() throws JAXBException, FileNotFoundException;
    void getAllToyotaCars() throws JAXBException;

    void getCarsAndParts() throws JAXBException;
}
