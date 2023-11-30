package com.example.football.service.impl;

import com.example.football.models.dto.TownSeedDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {

    private static final String TOWN_FILE_PATH = "skeleton/src/main/resources/files/json/towns.json";
    private static final String SUCCESSFUL_MESSAGE = "Successfully imported Town %s - %d";
    private static final String INVALID_MESSAGE = "Invalid Town";
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper mapper, ValidationUtil validationUtil, Gson gson) {
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
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
                message.append(String.format(SUCCESSFUL_MESSAGE, town.getName(), town.getPopulation()));
                message.append(System.lineSeparator());
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistTownWithName(String name) {
        return townRepository.findTownByName(name).isPresent();
    }
}
