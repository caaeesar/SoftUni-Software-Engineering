package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PlaneRootSeedDto;
import softuni.exam.models.dto.PlaneSeedDto;
import softuni.exam.models.entities.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaneServiceImpl implements PlaneService {

    private final static String PLANE_FILE_PATH = "src/main/resources/files/xml/planes.xml";
    private final static String SUCCESSFUL_MESSAGE = "Successfully imported Plane %s";
    private final static String INVALID_MESSAGE = "Invalid Plane";
    private final PlaneRepository planeRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.planeRepository = planeRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANE_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        StringBuilder message = new StringBuilder();

        List<PlaneSeedDto> planeSeedDtos = xmlParser.deserialize(PlaneRootSeedDto.class, Path.of(PLANE_FILE_PATH).toFile()).getPlanes().stream().collect(Collectors.toList());
        for (PlaneSeedDto planeSeedDto : planeSeedDtos) {

            if (!isExistPlaneWithRegisterNumber(planeSeedDto.getRegisterNumber()) && validationUtil.isValid(planeSeedDto)) {
                Plane plane = mapper.map(planeSeedDto, Plane.class);
                planeRepository.save(plane);
                message.append(String.format(SUCCESSFUL_MESSAGE, plane.getRegisterNumber())).append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistPlaneWithRegisterNumber(String registerNumber) {
        return planeRepository.findPlaneByRegisterNumber(registerNumber).isPresent();
    }
}
