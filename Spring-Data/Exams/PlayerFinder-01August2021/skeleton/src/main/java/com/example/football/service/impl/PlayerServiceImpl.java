package com.example.football.service.impl;

import com.example.football.models.dto.PlayerExport;
import com.example.football.models.dto.PlayerRootSeedDto;
import com.example.football.models.dto.PlayerSeedDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final static String SUCCESSFUL_MESSAGE = "Successfully imported Player %s %s - %s";
    private final static String INVALID_MESSAGE = "Invalid Player";
    private final static String PLAYER_FILE_PATH = "skeleton/src/main/resources/files/xml/players.xml";
    private final PlayerRepository playerRepository;
    private final TownRepository townRepository;
    private final TeamRepository teamRepository;
    private final StatRepository statRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TownRepository townRepository, TeamRepository teamRepository, StatRepository statRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
        this.statRepository = statRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYER_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        Converter<String, LocalDate> stringToLocalDateConverter
                = context -> LocalDate.parse(context.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        mapper.addConverter(stringToLocalDateConverter);

        mapper.typeMap(PlayerSeedDto.class, Player.class)
                .addMappings(mapper -> mapper.using(stringToLocalDateConverter)
                        .map(PlayerSeedDto::getBirthDate, Player::setBirthDate));

        StringBuilder message = new StringBuilder();

        List<PlayerSeedDto> playerSeedDtos = xmlParser.deserialize(PlayerRootSeedDto.class, Path.of(PLAYER_FILE_PATH).toFile()).getPlayers().stream().collect(Collectors.toList());
        for (PlayerSeedDto playerSeedDto : playerSeedDtos) {

            if (!isExistPlayerWithEmail(playerSeedDto.getEmail()) && validationUtil.isValid(playerSeedDto)) {

                Player player = mapper.map(playerSeedDto, Player.class);
                Town town = townRepository.getTownByName(playerSeedDto.getTown().getName());
                player.setTown(town);
                Team team = teamRepository.getTeamByName(playerSeedDto.getTeam().getName());
                player.setTeam(team);
                Stat stat = statRepository.getById(playerSeedDto.getStat().getId());
                player.setStat(stat);

                playerRepository.save(player);
                message.append(String.format(SUCCESSFUL_MESSAGE, player.getFirstName(), player.getLastName(), player.getPosition().name()));
                message.append(System.lineSeparator());
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistPlayerWithEmail(String email) {
        return playerRepository.findPlayerByEmail(email).isPresent();
    }

    @Override
    public String exportBestPlayers() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return playerRepository.getPlayersByBirthDateBetweenOrderByStatShootingDescStatPassingDescStatEnduranceDescLastNameAsc(LocalDate.parse("01/01/1995", df), LocalDate.parse("01/01/2003", df))
                .stream().map(player -> mapper.map(player, PlayerExport.class))
                .map(PlayerExport::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
