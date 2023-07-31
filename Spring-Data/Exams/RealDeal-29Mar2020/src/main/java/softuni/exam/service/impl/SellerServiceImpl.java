package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellerRootSeedDto;
import softuni.exam.models.dto.SellerSeedDto;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements SellerService {

    private final static Path SELLER_FILE_PATH = Path.of("src/main/resources/files/xml/sellers.xml");
    private final static String SUCCESSFUL_MESSAGE = "Successfully import seller %s - %s";
    private final static String INVALID_MESSAGE = "Invalid seller";
    private final SellerRepository sellerRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.sellerRepository = sellerRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(SELLER_FILE_PATH);
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder message = new StringBuilder();

        List<SellerSeedDto> sellerSeedDtos = xmlParser.deserialize(SellerRootSeedDto.class, SELLER_FILE_PATH.toFile()).getSellers().stream().collect(Collectors.toList());
        for (SellerSeedDto sellerSeedDto : sellerSeedDtos) {

            if (!isExistSellerWithEmail(sellerSeedDto.getEmail()) && validationUtil.isValid(sellerSeedDto)) {
                Seller seller = mapper.map(sellerSeedDto, Seller.class);
                sellerRepository.save(seller);
                message.append(String.format(SUCCESSFUL_MESSAGE, seller.getLastName(), seller.getEmail()))
                        .append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistSellerWithEmail(String email) {
        return sellerRepository.findSellerByEmail(email).isPresent();
    }
}
