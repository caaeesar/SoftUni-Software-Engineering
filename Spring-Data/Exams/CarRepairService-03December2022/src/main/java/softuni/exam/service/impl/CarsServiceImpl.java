package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarRootSeedDto;
import softuni.exam.models.dto.CarSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsServiceImpl implements CarsService {
    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";
    private static final String SUCCESSFUL_MESSAGE = "Successfully imported car %s - %s";
    private static final String INVALID_MESSAGE = "Invalid car";
    private final CarsRepository carsRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public CarsServiceImpl(CarsRepository carsRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.carsRepository = carsRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return carsRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        StringBuilder message = new StringBuilder();

        List<CarSeedDto> carSeedDtos = xmlParser.deserialize(CarRootSeedDto.class, Path.of(CARS_FILE_PATH).toFile())
                .getCars().stream().collect(Collectors.toList());


        for (CarSeedDto carSeedDto : carSeedDtos) {
            if (!isExistCarWithSamePlateNumber(carSeedDto.getPlateNumber()) && validationUtil.isValid(carSeedDto)) {
                Car car = mapper.map(carSeedDto, Car.class);
                carsRepository.save(car);
                message.append(String.format(SUCCESSFUL_MESSAGE, car.getCarMake(), car.getCarModel()));
                message.append(System.lineSeparator());
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistCarWithSamePlateNumber(String plateNumber) {
        return carsRepository.findCarByPlateNumber(plateNumber).isPresent();
    }
}
