package softuni.exam.service.impl;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerRootSeedDto;
import softuni.exam.models.dto.AstronomerSeedDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.io.PipedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AstronomerServiceImpl implements AstronomerService {

    private final static Path ASTRONOMER_FILE_PATH = Path.of("src/main/resources/files/xml/astronomers.xml");
    private final static String SUCCESSFUL_MESSAGE = "Successfully imported astronomer %s %s - %.2f";
    private final static String INVALID_MESSAGE = "Invalid astronomer";
    private final AstronomerRepository astronomerRepository;
    private final StarRepository starRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, StarRepository starRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(ASTRONOMER_FILE_PATH);
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        Converter<String, LocalDate> stringToLocalDateConverter
                = context -> LocalDate.parse(context.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        mapper.typeMap(AstronomerSeedDto.class, Astronomer.class)
                .addMappings(mapper -> mapper.using(stringToLocalDateConverter)
                        .map(AstronomerSeedDto::getBirthday, Astronomer::setBirthday));

        StringBuilder message = new StringBuilder();

        List<AstronomerSeedDto> astronomerSeedDtos = xmlParser.deserialize(AstronomerRootSeedDto.class, ASTRONOMER_FILE_PATH.toFile()).getAstronomers().stream().collect(Collectors.toList());
        for (AstronomerSeedDto astronomerSeedDto : astronomerSeedDtos) {

            if (!isExistAstronomerWithNames(astronomerSeedDto.getFirstName(), astronomerSeedDto.getLastName())
            && isExistStarWithId(astronomerSeedDto.getObservingStar())
            && validationUtil.isValid(astronomerSeedDto)) {

                Astronomer astronomer = mapper.map(astronomerSeedDto, Astronomer.class);
                Star star = starRepository.getById(astronomerSeedDto.getObservingStar());
                astronomer.setObservingStar(star);
                astronomerRepository.save(astronomer);
                message.append(String.format(SUCCESSFUL_MESSAGE, astronomer.getFirstName(), astronomer.getLastName(), astronomer.getAverageObservationHours()))
                        .append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistStarWithId(Long id) {
        return starRepository.findStarById(id).isPresent();
    }

    private boolean isExistAstronomerWithNames(String firstName, String lastName) {
        return astronomerRepository.findAstronomerByFirstNameAndLastName(firstName, lastName).isPresent();
    }
}
