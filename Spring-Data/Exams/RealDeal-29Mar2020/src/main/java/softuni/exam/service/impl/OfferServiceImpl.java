package softuni.exam.service.impl;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferRootSeedDto;
import softuni.exam.models.dto.OfferSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final static Path OFFER_FILE_PATH = Path.of("src/main/resources/files/xml/offers.xml");
    private final static String SUCCESSFUL_MESSAGE = "Successfully import offer %s - %s";
    private final static String INVALID_MESSAGE = "Invalid offer";
    private final OfferRepository offerRepository;
    private final SellerRepository sellerRepository;
    private final CarRepository carRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, SellerRepository sellerRepository, CarRepository carRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.offerRepository = offerRepository;
        this.sellerRepository = sellerRepository;
        this.carRepository = carRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(OFFER_FILE_PATH);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        Converter<String, LocalDateTime> stringToLocalDateTimeConverter
                = context -> LocalDateTime.parse(context.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        mapper.typeMap(OfferSeedDto.class, Offer.class)
                .addMappings(mapper -> mapper.using(stringToLocalDateTimeConverter)
                        .map(OfferSeedDto::getAddedOn, Offer::setAddedOn));

        StringBuilder message = new StringBuilder();

        List<OfferSeedDto> offerSeedDtos = xmlParser.deserialize(OfferRootSeedDto.class, OFFER_FILE_PATH.toFile()).getOffers().stream().collect(Collectors.toList());
        for (OfferSeedDto offerSeedDto : offerSeedDtos) {
            if (carRepository.existsById(offerSeedDto.getCar().getId())
                    && sellerRepository.existsById(offerSeedDto.getSeller().getId())
                    && validationUtil.isValid(offerSeedDto)) {
                Offer offer = mapper.map(offerSeedDto, Offer.class);
                Car car = carRepository.getOne(offerSeedDto.getCar().getId());
                offer.setCar(car);
                Seller seller = sellerRepository.getOne(offerSeedDto.getSeller().getId());
                offer.setSeller(seller);
                offerRepository.save(offer);

                message.append(String.format(SUCCESSFUL_MESSAGE, offer.getAddedOn(), offer.getHasGoldStatus()))
                        .append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }
}
