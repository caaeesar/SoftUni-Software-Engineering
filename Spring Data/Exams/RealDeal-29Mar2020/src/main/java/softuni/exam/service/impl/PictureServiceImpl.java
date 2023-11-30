package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PictureSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    private final static Path PICTURE_FILE_PATH = Path.of("src/main/resources/files/json/pictures.json");
    private final static String SUCCESSFUL_MESSAGE = "Successfully import picture - %s";
    private final static String INVALID_MESSAGE = "Invalid picture";
    private final PictureRepository pictureRepository;
    private final CarRepository carRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public PictureServiceImpl(PictureRepository pictureRepository, CarRepository carRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.carRepository = carRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(PICTURE_FILE_PATH);
    }

    @Override
    public String importPictures() throws IOException {
        Converter<String, LocalDateTime> stringToLocalTimeConverter
                = context -> LocalDateTime.parse(context.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        mapper.typeMap(PictureSeedDto.class, Picture.class).
                addMappings(mapper -> mapper.using(stringToLocalTimeConverter)
                        .map(PictureSeedDto::getDateAndTime, Picture::setDateAndTime));

        StringBuilder message = new StringBuilder();

        List<PictureSeedDto> pictureSeedDtos = Arrays.stream(gson.fromJson(readPicturesFromFile(), PictureSeedDto[].class)).collect(Collectors.toList());
        for (PictureSeedDto pictureSeedDto : pictureSeedDtos) {

            if (!isExistPictureWithName(pictureSeedDto.getName())
                && isExistCarWithId(pictureSeedDto.getCar())
                && validationUtil.isValid(pictureSeedDto)) {

                Picture picture = mapper.map(pictureSeedDto, Picture.class);
                Car car = carRepository.getOne(pictureSeedDto.getCar());
                picture.setCar(car);
                pictureRepository.save(picture);
                message.append(String.format(SUCCESSFUL_MESSAGE, picture.getName())).append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistCarWithId(Long id) {
        return carRepository.existsById(id);
    }

    private boolean isExistPictureWithName(String name) {
        return pictureRepository.findPictureByName(name).isPresent();
    }
}
