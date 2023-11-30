package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicSeedDto;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MechanicsServiceImpl implements MechanicsService {
    private static final String MECHANICS_FILE_PATH = "src/main/resources/files/json/mechanics.json";
    private static final String SUCCESSFUL_MESSAGE = "Successfully imported mechanic %s %s";
    private static final String INVALID_MESSAGE = "Invalid mechanic";

    private final MechanicsRepository mechanicsRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public MechanicsServiceImpl(MechanicsRepository mechanicsRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.mechanicsRepository = mechanicsRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return mechanicsRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANICS_FILE_PATH));
    }

    @Override
    public String importMechanics() throws IOException {
        StringBuilder message = new StringBuilder();

        List<MechanicSeedDto> mechanicSeedDtos = Arrays.stream(gson.fromJson(readMechanicsFromFile(), MechanicSeedDto[].class)).collect(Collectors.toList());
        for (MechanicSeedDto mechanicSeedDto : mechanicSeedDtos) {

            if (!isExistMechanicWithSameEmail(mechanicSeedDto.getEmail()) && validationUtil.isValid(mechanicSeedDto)) {
                Mechanic mechanic = mapper.map(mechanicSeedDto, Mechanic.class);
                mechanicsRepository.save(mechanic);
                message.append(String.format(SUCCESSFUL_MESSAGE, mechanic.getFirstName(), mechanic.getLastName()));
                message.append(System.lineSeparator());
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistMechanicWithSameEmail(String email) {
        return mechanicsRepository.findMechanicByEmail(email).isPresent();
    }
}
