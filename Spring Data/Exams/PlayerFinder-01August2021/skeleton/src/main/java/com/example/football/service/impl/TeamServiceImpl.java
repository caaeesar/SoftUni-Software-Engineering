package com.example.football.service.impl;

import com.example.football.models.dto.TeamSeedDto;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
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
public class TeamServiceImpl implements TeamService {

    private final static String TEAM_FILE_PATH = "skeleton/src/main/resources/files/json/teams.json";
    private final static String SUCCESSFUL_MESSAGE = "Successfully imported Team %s - %d";
    private final static String INVALID_MESSAGE = "Invalid Team";
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAM_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder message = new StringBuilder();

        List<TeamSeedDto> teamSeedDtos = Arrays.stream(gson.fromJson(readTeamsFileContent(), TeamSeedDto[].class)).collect(Collectors.toList());
        for (TeamSeedDto teamSeedDto : teamSeedDtos) {

            if (!isExistTeamWithName(teamSeedDto.getName()) && validationUtil.isValid(teamSeedDto)) {
                Team team = mapper.map(teamSeedDto, Team.class);
                Town town = townRepository.getTownByName(teamSeedDto.getTownName());

                team.setTown(town);
                teamRepository.save(team);
                message.append(String.format(SUCCESSFUL_MESSAGE, team.getName(), team.getFanBase()));
                message.append(System.lineSeparator());
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistTeamWithName(String name) {
        return teamRepository.findTeamByName(name).isPresent();
    }
}
