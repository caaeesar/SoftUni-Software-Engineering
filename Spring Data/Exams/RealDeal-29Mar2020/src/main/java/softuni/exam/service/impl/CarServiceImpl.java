package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarExportDto;
import softuni.exam.models.dto.CarSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final static Path CAR_FILE_PATH = Path.of("src/main/resources/files/json/cars.json");
    private final static String SUCCESSFUL_MESSAGE = "Successfully imported car - %s - %s";
    private final static String INVALID_MESSAGE = "Invalid car";
    private final CarRepository carRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(CAR_FILE_PATH);
    }

    @Override
    public String importCars() throws IOException {
        Converter<String, LocalDate> stringToLocalDateConverter
                = context -> LocalDate.parse(context.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        mapper.typeMap(CarSeedDto.class, Car.class)
                .addMappings(mapper -> mapper.using(stringToLocalDateConverter)
                        .map(CarSeedDto::getRegisteredOn, Car::setRegisteredOn));

        StringBuilder message = new StringBuilder();

        List<CarSeedDto> carSeedDtos = Arrays.stream(gson.fromJson(readCarsFileContent(), CarSeedDto[].class)).collect(Collectors.toList());
        for (CarSeedDto carSeedDto : carSeedDtos) {
            if (validationUtil.isValid(carSeedDto)) {
                Car car = mapper.map(carSeedDto, Car.class);
                carRepository.save(car);
                message.append(String.format(SUCCESSFUL_MESSAGE, car.getMake(), car.getModel())).append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        return carRepository.getCarsWithPicturesCount()
                .stream()
                .map(car -> mapper.map(car, CarExportDto.class))
                .map(CarExportDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
