package com.example.football.service.impl;

import com.example.football.models.dto.StatRootSeedDto;
import com.example.football.models.dto.StatSeedDto;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatServiceImpl implements StatService {

    private final static String SUCCESSFUL_MESSAGE = "Successfully imported Stat %.2f - %.2f - %.2f";
    private final static String INVALID_MESSAGE = "Invalid Stat";
    private final static String STAT_FILE_PATH = "skeleton/src/main/resources/files/xml/stats.xml";
    private final StatRepository statRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public StatServiceImpl(StatRepository statRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.statRepository = statRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STAT_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StringBuilder message = new StringBuilder();

        List<StatSeedDto> statSeedDtos = xmlParser.deserialize(StatRootSeedDto.class, Path.of(STAT_FILE_PATH).toFile()).getStats().stream().collect(Collectors.toList());
        for (StatSeedDto statSeedDto : statSeedDtos) {

            if (!isExistStatCombination(statSeedDto.getPassing(), statSeedDto.getShooting(), statSeedDto.getEndurance())
                    && validationUtil.isValid(statSeedDto)) {
                Stat stat = mapper.map(statSeedDto, Stat.class);
                statRepository.save(stat);
                message.append(String.format(SUCCESSFUL_MESSAGE, stat.getPassing(), stat.getShooting(),stat.getEndurance()));
                message.append(System.lineSeparator());
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistStatCombination(Double passing, Double shooting, Double endurance) {
        return statRepository.findStatByPassingAndShootingAndEndurance(passing, shooting, endurance).isPresent();
    }
}
