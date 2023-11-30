package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.dao.CarRepository;
import bg.softuni.cardealer.dao.PartRepository;
import bg.softuni.cardealer.model.dto.exportDtos.CarsWithPartsDto;
import bg.softuni.cardealer.model.dto.importDtos.CarSeedDto;
import bg.softuni.cardealer.model.dto.exportDtos.CarWithMakeToyotaDto;
import bg.softuni.cardealer.model.entity.Car;
import bg.softuni.cardealer.model.entity.Part;
import bg.softuni.cardealer.service.CarService;
import bg.softuni.cardealer.utils.JsonWriterUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static bg.softuni.cardealer.constants.FilesPath.*;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepo;
    private final PartRepository partRepo;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CarServiceImpl(CarRepository carRepo, PartRepository partRepo, ModelMapper modelMapper, Gson gson) {
        this.carRepo = carRepo;
        this.partRepo = partRepo;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedCars() throws IOException {
        if (this.carRepo.count() > 0) {
            return;
        }

        String fileContent = Files.readString(Path.of(ROOT_IN_FILE_PATH + CARS_FILE_NAME));
        CarSeedDto[] dtos = this.gson.fromJson(fileContent, CarSeedDto[].class);

        List<Car> cars = Arrays.stream(dtos).map(carSeedDto -> this.modelMapper.map(carSeedDto, Car.class)).toList();
        cars.forEach(car -> car.setParts(getRandomParts()));
        this.carRepo.saveAll(cars);

    }

    @Override
    public void getAllToyotaCars() throws IOException {
        List<CarWithMakeToyotaDto> dtos = this.carRepo.getCarsByMakeIsOrderByModelAscTravelledDistanceDesc("Toyota")
                .stream()
                .map(car -> this.modelMapper.map(car, CarWithMakeToyotaDto.class))
                .toList();
        String jsonContent = this.gson.toJson(dtos);
        JsonWriterUtil.writeToJson(Collections.singletonList(jsonContent), Path.of(ROOT_OUT_FILE_PATH + CARS_TOYOTA_MAKE_FILE_PATH));
    }

    @Override
    public void getCarsAndParts() throws IOException {
        List<CarsWithPartsDto> dtos = this.carRepo.getCarsBy().stream()
                .map(car -> this.modelMapper.map(car, CarsWithPartsDto.class))
                .toList();
        String jsonContent = this.gson.toJson(dtos);
        JsonWriterUtil.writeToJson(Collections.singletonList(jsonContent), Path.of(ROOT_OUT_FILE_PATH + CARS_AND_PARTS_FILE_PATH));
    }


    private List<Part> getRandomParts() {
        Random rng = new Random();
        int bound = rng.nextInt(3, 6);
        List<Part> randomParts = new ArrayList<>();
        for (int i = 0; i < bound; i++) {
        long randomId = rng.nextLong(this.partRepo.count()) + 1;
            randomParts.add(this.partRepo.findById(randomId).get());
        }
        return randomParts;
    }
}
