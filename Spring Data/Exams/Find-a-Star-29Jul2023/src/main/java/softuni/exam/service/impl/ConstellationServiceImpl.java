package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationSeedDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConstellationServiceImpl implements ConstellationService {

    private final static Path CONSTELLATION_FILE_PATH = Path.of("src/main/resources/files/json/constellations.json");
    private final static String SUCCESSFUL_MESSAGE = "Successfully imported constellation %s - %s";
    private final static String INVALID_MESSAGE = "Invalid constellation";
    private final ConstellationRepository constellationRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public ConstellationServiceImpl(ConstellationRepository constellationRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.constellationRepository = constellationRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(CONSTELLATION_FILE_PATH);
    }

    @Override
    public String importConstellations() throws IOException {
        StringBuilder message = new StringBuilder();

        List<ConstellationSeedDto> constellationSeedDtos = Arrays.stream(gson.fromJson(readConstellationsFromFile(), ConstellationSeedDto[].class)).collect(Collectors.toList());
        for (ConstellationSeedDto constellationSeedDto : constellationSeedDtos) {

            if (!isExistConstellationWithName(constellationSeedDto.getName()) && validationUtil.isValid(constellationSeedDto)) {
                Constellation constellation = mapper.map(constellationSeedDto, Constellation.class);
                constellationRepository.save(constellation);
                message.append(String.format(SUCCESSFUL_MESSAGE,constellation.getName(),constellation.getDescription()))
                        .append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistConstellationWithName(String name) {
        return constellationRepository.findConstellationByName(name).isPresent();
    }
}
