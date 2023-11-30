package exam.service.impl;

import exam.model.dto.TownRootSeedDto;
import exam.model.dto.TownSeedDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
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
public class TownServiceImpl implements TownService {

    private final static String SUCCESSFUL_MESSAGE = "Successfully imported Town %s";
    private final static String INVALID_MESSAGE = "Invalid town";
    private final static String TOWN_FILE_PATH = "src/main/resources/files/xml/towns.xml";
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
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
    public String importTowns() throws JAXBException, FileNotFoundException {
        StringBuilder message = new StringBuilder();

        List<TownSeedDto> townSeedDtos = xmlParser.deserialize(TownRootSeedDto.class, Path.of(TOWN_FILE_PATH).toFile()).getTowns().stream().collect(Collectors.toList());
        for (TownSeedDto townSeedDto : townSeedDtos) {

            if (!isExistTownWithName(townSeedDto.getName()) && validationUtil.isValid(townSeedDto)) {
                Town town = mapper.map(townSeedDto, Town.class);
                townRepository.save(town);
                message.append(String.format(SUCCESSFUL_MESSAGE, town.getName()));
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
