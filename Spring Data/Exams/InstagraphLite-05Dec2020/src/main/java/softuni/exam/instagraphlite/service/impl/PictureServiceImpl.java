package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PictureExportDto;
import softuni.exam.instagraphlite.models.dto.PictureSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    private final static String SUCCESSFUL_MESSAGE = "Successfully imported Picture, with size %.2f";
    private final static String INVALID_MESSAGE = "Invalid Picture";
    private final static String PICTURE_FILE_PATH = "src/main/resources/files/pictures.json";
    private final PictureRepository pictureRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURE_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder message = new StringBuilder();

        List<PictureSeedDto> pictureSeedDtos = Arrays.stream(gson.fromJson(readFromFileContent(), PictureSeedDto[].class)).collect(Collectors.toList());
        for (PictureSeedDto pictureSeedDto : pictureSeedDtos) {

            if (!isExistPictureWithPath(pictureSeedDto.getPath()) && validationUtil.isValid(pictureSeedDto)) {
                Picture picture = mapper.map(pictureSeedDto, Picture.class);
                pictureRepository.save(picture);
                message.append(String.format(SUCCESSFUL_MESSAGE, picture.getSize())).append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistPictureWithPath(String path) {
        return pictureRepository.findPictureByPath(path).isPresent();
    }

    @Override
    public String exportPictures() {
        return pictureRepository.getPicturesBySizeGreaterThanOrderBySizeAsc(30000.00)
                .stream().map(picture -> mapper.map(picture, PictureExportDto.class))
                .map(PictureExportDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
