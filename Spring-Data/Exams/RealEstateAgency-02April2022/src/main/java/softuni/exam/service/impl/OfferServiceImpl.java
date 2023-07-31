package softuni.exam.service.impl;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferExportDto;
import softuni.exam.models.dto.OfferRootSeedDto;
import softuni.exam.models.dto.OfferSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.enums.ApartmentType;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private static final String OFFER_FILE_PATH = "src/main/resources/files/xml/offers.xml";
    private static final String SUCCESSFUL_MESSAGE = "Successfully imported offer %s";
    private static final String INVALID_MESSAGE = "Invalid offer";
    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, AgentRepository agentRepository, ApartmentRepository apartmentRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
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
        return Files.readString(Path.of(OFFER_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        Converter<String, LocalDate> stringToLocalDateTimeConverter
                = context -> LocalDate.parse(context.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        mapper.typeMap(OfferSeedDto.class, Offer.class)
                .addMappings(mapper -> mapper.using(stringToLocalDateTimeConverter)
                        .map(OfferSeedDto::getPublishedOn, Offer::setPublishedOn));

        StringBuilder message = new StringBuilder();

        List<OfferSeedDto> offerSeedDtos = xmlParser.deserialize(OfferRootSeedDto.class, Path.of(OFFER_FILE_PATH).toFile()).getOffers().stream().collect(Collectors.toList());

        for (OfferSeedDto offerSeedDto : offerSeedDtos) {

            if (isExistAgentWithName(offerSeedDto.getAgent().getFirstName()) && validationUtil.isValid(offerSeedDto)) {

                Offer offer = mapper.map(offerSeedDto, Offer.class);
                Agent agent = agentRepository.findAgentByFirstName(offerSeedDto.getAgent().getFirstName()).get();
                Apartment apartment = apartmentRepository.getById(offerSeedDto.getApartment().getId());

                offer.setAgent(agent);
                offer.setApartment(apartment);

                offerRepository.save(offer);
                message.append(String.format(SUCCESSFUL_MESSAGE, offer.getPrice().setScale(2)));
                message.append(System.lineSeparator());
            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistAgentWithName(String firstName) {
        return agentRepository.findAgentByFirstName(firstName).isPresent();
    }

    @Override
    public String exportOffers() {
       return offerRepository.findOffersByApartment_ApartmentTypeOrderByApartment_AreaDescPriceAsc(ApartmentType.three_rooms)
               .stream()
               .map(offer -> mapper.map(offer, OfferExportDto.class))
               .map(OfferExportDto::toString)
               .collect(Collectors.joining(System.lineSeparator()));
    }
}
