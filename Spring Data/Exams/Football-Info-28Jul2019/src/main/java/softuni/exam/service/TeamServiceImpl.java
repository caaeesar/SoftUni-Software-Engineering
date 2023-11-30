package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.TeamRootSeedDto;
import softuni.exam.domain.dto.TeamSeedDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.TeamRepository;
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
public class TeamServiceImpl implements TeamService {

    private final static Path TEAM_FILE_PATH = Path.of("src/main/resources/files/xml/teams.xml");
    private final static String SUCCESSFUL_MESSAGE = "Successfully imported - %s";
    private final static String INVALID_MESSAGE = "Invalid team";
    private final TeamRepository teamRepository;
    private final PictureRepository pictureRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, PictureRepository pictureRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.teamRepository = teamRepository;
        this.pictureRepository = pictureRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public String importTeams() {
        StringBuilder message = new StringBuilder();

        List<TeamSeedDto> teamSeedDtos = null;
        try {
            teamSeedDtos = xmlParser.deserialize(TeamRootSeedDto.class, TEAM_FILE_PATH.toFile()).getTeams().stream().collect(Collectors.toList());
        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (TeamSeedDto teamSeedDto : teamSeedDtos) {
            if (isExistPictureWithUrl(teamSeedDto.getPicture().getUrl()) && validationUtil.isValid(teamSeedDto)) {
                Team team = mapper.map(teamSeedDto, Team.class);
                Picture picture = pictureRepository.getPictureByUrl(teamSeedDto.getPicture().getUrl());
                team.setPicture(picture);
                teamRepository.save(team);
                message.append(String.format(SUCCESSFUL_MESSAGE, team.getName())).append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistPictureWithUrl(String url) {
        return pictureRepository.findPictureByUrl(url).isPresent();
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return Files.readString(TEAM_FILE_PATH);
    }
}
