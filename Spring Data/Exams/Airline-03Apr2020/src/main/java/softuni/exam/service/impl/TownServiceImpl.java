package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownSeedDto;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {

    private final static String TOWN_FILE_PATH = "src/main/resources/files/json/towns.json";
    private final static String SUCCESSFUL_MESSAGE = "Successfully imported Town %s - %d";
    private final static String INVALID_MESSAGE = "Invalid Town";
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder message = new StringBuilder();

        List<TownSeedDto> townSeedDtos = Arrays.stream(gson.fromJson(readTownsFileContent(), TownSeedDto[].class)).collect(Collectors.toList());
        for (TownSeedDto townSeedDto : townSeedDtos) {

            if (!isExistTownWithName(townSeedDto.getName()) && validationUtil.isValid(townSeedDto)) {
                Town town = mapper.map(townSeedDto, Town.class);
                townRepository.save(town);
                message.append(String.format(SUCCESSFUL_MESSAGE, town.getName(), town.getPopulation())).append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistTownWithName(String name) {
        return townRepository.findTownByName(name).isPresent();
    }
}
