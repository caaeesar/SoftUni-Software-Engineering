package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.PlayerInTeamExportDto;
import softuni.exam.domain.dto.PlayerSalaryExportDto;
import softuni.exam.domain.dto.PlayerSeedDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final static Path PLAYER_FILE_PATH = Path.of("src/main/resources/files/json/players.json");
    private final static String SUCCESSFUL_MESSAGE = "Successfully imported player: %s %s";
    private final static String INVALID_MESSAGE = "Invalid player";
    private final PlayerRepository playerRepository;
    private final PictureRepository pictureRepository;
    private final TeamRepository teamRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, PictureRepository pictureRepository, TeamRepository teamRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.playerRepository = playerRepository;
        this.pictureRepository = pictureRepository;
        this.teamRepository = teamRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public String importPlayers() throws IOException {
        StringBuilder message = new StringBuilder();

        List<PlayerSeedDto> playerSeedDtos = Arrays.stream(gson.fromJson(readPlayersJsonFile(), PlayerSeedDto[].class)).collect(Collectors.toList());
        for (PlayerSeedDto playerSeedDto : playerSeedDtos) {
            if (isExistPictureWithUrl(playerSeedDto.getPicture().getUrl())
                    && isExistTeamWithName(playerSeedDto.getTeam().getName())
                    && validationUtil.isValid(playerSeedDto)) {
                Player player = mapper.map(playerSeedDto, Player.class);
                Picture picture = pictureRepository.getPictureByUrl(playerSeedDto.getPicture().getUrl());
                player.setPicture(picture);
                Team team = teamRepository.getTeamByName(playerSeedDto.getTeam().getName());
                player.setTeam(team);
                playerRepository.save(player);
                message.append(String.format(SUCCESSFUL_MESSAGE, player.getFirstName(), player.getLastName())).append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistTeamWithName(String name) {
        return teamRepository.findTeamByName(name).isPresent();
    }

    private boolean isExistPictureWithUrl(String url) {
        return pictureRepository.findPictureByUrl(url).isPresent();
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return Files.readString(PLAYER_FILE_PATH);
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        return playerRepository.getPlayersBySalaryGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000))
                .stream()
                .map(player -> mapper.map(player, PlayerSalaryExportDto.class))
                .map(PlayerSalaryExportDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String exportPlayersInATeam() {
        return playerRepository.getPlayersByTeamNameOrderById("North Hub")
                .stream()
                .map(player -> mapper.map(player, PlayerInTeamExportDto.class))
                .map(PlayerInTeamExportDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
