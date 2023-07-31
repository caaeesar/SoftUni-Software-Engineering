package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.dao.CarRepository;
import bg.softuni.cardealer.dao.PartRepository;
import bg.softuni.cardealer.model.dto.exports.CarRootWithPartsDto;
import bg.softuni.cardealer.model.dto.exports.CarWithPartsDto;
import bg.softuni.cardealer.model.dto.exports.CarRootWithMakeToyotaDto;
import bg.softuni.cardealer.model.dto.exports.CarWithMakeToyotaDto;
import bg.softuni.cardealer.model.dto.imports.CarRootSeedDto;
import bg.softuni.cardealer.model.entity.Car;
import bg.softuni.cardealer.model.entity.Part;
import bg.softuni.cardealer.service.CarService;
import bg.softuni.cardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static bg.softuni.cardealer.constants.FilePaths.*;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, ModelMapper mapper, XmlParser xmlParser) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCars() throws JAXBException, FileNotFoundException {
        if (carRepository.count() > 0) {
            return;
        }
        CarRootSeedDto rootSeedDto = xmlParser.deserialize(CarRootSeedDto.class, ROOT_IN_FILE_PATH + CARS_FILE_NAME);
        List<Car> cars = rootSeedDto.getCars()
                .stream()
                .map(carSeedDto -> mapper.map(carSeedDto, Car.class))
                .toList();
        cars.forEach(car -> car.setParts(getRandomParts()));
        carRepository.saveAll(cars);
    }

    @Override
    public void getAllToyotaCars() throws JAXBException {
        List<CarWithMakeToyotaDto> toyotaDtos = carRepository.getCarsByMakeIsOrderByModelAscTravelledDistanceDesc("Toyota")
                .stream()
                .map(car -> mapper.map(car, CarWithMakeToyotaDto.class))
                .toList();
        CarRootWithMakeToyotaDto rootDto = new CarRootWithMakeToyotaDto();
        rootDto.setCars(toyotaDtos);
        xmlParser.serialize(rootDto, ROOT_OUT_FILE_PATH + CARS_TOYOTA_MAKE_FILE_PATH);
    }

    @Override
    public void getCarsAndParts() throws JAXBException {
        List<CarWithPartsDto> carWithPartsDtos = carRepository.getCarsBy()
                .stream()
                .map(car -> mapper.map(car, CarWithPartsDto.class))
                .toList();
        CarRootWithPartsDto rootCar = new CarRootWithPartsDto();
        rootCar.setCars(carWithPartsDtos);
        xmlParser.serialize(rootCar, ROOT_OUT_FILE_PATH + CARS_AND_PARTS_FILE_PATH);
    }

    private List<Part> getRandomParts() {
        Random rng = new Random();
        int bound = rng.nextInt(3, 6);
        List<Part> randomParts = new ArrayList<>();
        for (int i = 0; i < bound; i++) {
            long randomId = rng.nextLong(this.partRepository.count()) + 1;
            randomParts.add(this.partRepository.findById(randomId).get());
        }
        return randomParts;
    }
}
