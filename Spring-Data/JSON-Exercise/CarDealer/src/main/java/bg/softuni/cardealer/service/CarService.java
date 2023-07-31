package bg.softuni.cardealer.service;


import java.io.IOException;

public interface CarService {

    void seedCars() throws IOException;

    void getAllToyotaCars() throws IOException;

    void getCarsAndParts() throws IOException;
}
