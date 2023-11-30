package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentRootSeedDto;
import softuni.exam.models.dto.ApartmentSeedDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private static final String APARTMENT_FILE_PATH = "src/main/resources/files/xml/apartments.xml";
    private static final String SUCCESSFUL_MESSAGE = "Successfully imported apartment %s - %s";
    private static final String INVALID_MESSAGE = "Invalid apartment";
    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, TownRepository townRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENT_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder message = new StringBuilder();

        List<ApartmentSeedDto> apartmentSeedDtos = xmlParser.deserialize(ApartmentRootSeedDto.class, Path.of(APARTMENT_FILE_PATH).toFile()).getApartments().stream().collect(Collectors.toList());

        for (ApartmentSeedDto apartmentSeedDto : apartmentSeedDtos) {

            if (!isExistApartmentWithTownName(apartmentSeedDto.getTown(), apartmentSeedDto.getArea()) && validationUtil.isValid(apartmentSeedDto)) {
                Apartment apartment = mapper.map(apartmentSeedDto, Apartment.class);
                Town town = townRepository.findTownByTownName(apartmentSeedDto.getTown()).get();
                apartment.setTown(town);
                apartmentRepository.save(apartment);
                message.append(String.format(SUCCESSFUL_MESSAGE, apartment.getApartmentType().name(), apartment.getArea()));
                message.append(System.lineSeparator());
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistApartmentWithTownName(String town, Double area) {
        return apartmentRepository.findApartmentByTownTownNameAndArea(town,area).isPresent();
    }
}
