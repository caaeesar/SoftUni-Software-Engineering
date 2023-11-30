package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartSeedDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartsServiceImpl implements PartsService {

    private static final String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";
    private static final String SUCCESSFUL_MESSAGE = "Successfully imported part %s - %s";
    private static final String INVALID_MESSAGE = "Invalid part";
    private final PartsRepository partsRepository;
    private final Gson gson;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public PartsServiceImpl(PartsRepository partsRepository, Gson gson, ModelMapper mapper, ValidationUtil validationUtil) {
        this.partsRepository = partsRepository;
        this.gson = gson;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {
        StringBuilder message = new StringBuilder();

        List<PartSeedDto> partSeedDtos = Arrays.stream(gson.fromJson(readPartsFileContent(), PartSeedDto[].class)).collect(Collectors.toList());

        for (PartSeedDto partSeedDto : partSeedDtos) {

            if (!isExistPartWithSameName(partSeedDto.getPartName()) && validationUtil.isValid(partSeedDto)) {
                Part part = mapper.map(partSeedDto, Part.class);
                message.append(String.format(SUCCESSFUL_MESSAGE, part.getPartName(), part.getPrice()));
                message.append(System.lineSeparator());
                partsRepository.save(part);
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }

        return message.toString().trim();
    }

    private boolean isExistPartWithSameName(String name) {
        return partsRepository.findPartByPartName(name).isPresent();
    }

}
