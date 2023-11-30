package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.PictureRootSeedDto;
import softuni.exam.domain.dto.PictureSeedDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
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
public class PictureServiceImpl implements PictureService {

    private final static Path PICTURE_FILE_PATH = Path.of("src/main/resources/files/xml/pictures.xml");
    private final static String SUCCESSFUL_MESSAGE = "Successfully imported picture - %s";
    private final static String INVALID_MESSAGE = "Invalid picture";
    private final PictureRepository pictureRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public String importPictures() throws JAXBException {
        StringBuilder message = new StringBuilder();

        List<PictureSeedDto> pictureSeedDtos = null;
        try {
            pictureSeedDtos = xmlParser.deserialize(PictureRootSeedDto.class, PICTURE_FILE_PATH.toFile()).getPictures().stream().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (PictureSeedDto pictureSeedDto : pictureSeedDtos) {

            if (validationUtil.isValid(pictureSeedDto)) {
                Picture picture = mapper.map(pictureSeedDto, Picture.class);
                pictureRepository.save(picture);
                message.append(String.format(SUCCESSFUL_MESSAGE, picture.getUrl())).append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return Files.readString(PICTURE_FILE_PATH);
    }

}
