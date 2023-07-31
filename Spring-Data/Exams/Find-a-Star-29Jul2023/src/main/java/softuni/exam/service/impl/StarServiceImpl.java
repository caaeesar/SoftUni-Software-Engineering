package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarExportDto;
import softuni.exam.models.dto.StarSeedDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.enums.StarType;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarServiceImpl implements StarService {

    private final static Path STAR_FILE_PATH = Path.of("src/main/resources/files/json/stars.json");
    private final static String SUCCESSFUL_MESSAGE = "Successfully imported star %s - %.2f light years";
    private final static String INVALID_MESSAGE = "Invalid star";
    private final StarRepository starRepository;
    private final ConstellationRepository constellationRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public StarServiceImpl(StarRepository starRepository, ConstellationRepository constellationRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(STAR_FILE_PATH);
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder message = new StringBuilder();

        List<StarSeedDto> starSeedDtos = Arrays.stream(gson.fromJson(readStarsFileContent(), StarSeedDto[].class)).collect(Collectors.toList());
        for (StarSeedDto starSeedDto : starSeedDtos) {
            if (!isExistStarWithName(starSeedDto.getName()) && validationUtil.isValid(starSeedDto)) {
                Star star = mapper.map(starSeedDto, Star.class);
                Constellation constellation = constellationRepository.getById(starSeedDto.getConstellation());
                star.setConstellation(constellation);
                starRepository.save(star);
                message.append(String.format(SUCCESSFUL_MESSAGE, star.getName(), star.getLightYears()))
                        .append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    @Override
    public String exportStars() {
        return starRepository.getRedGiantsWithoutObservers(StarType.RED_GIANT)
                .stream()
                .map(star -> mapper.map(star, StarExportDto.class))
                .map(StarExportDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
    private boolean isExistStarWithName(String name) {
        return starRepository.findStarByName(name).isPresent();
    }
}
