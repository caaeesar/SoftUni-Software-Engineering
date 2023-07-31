package exam.service.impl;

import exam.model.dto.ShopRootSeedDto;
import exam.model.dto.ShopSeedDto;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
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
public class ShopServiceImpl implements ShopService {

    private final static String SUCCESSFUL_MESSAGE = "Successfully imported Shop %s - %.0f";
    private final static String INVALID_MESSAGE = "Invalid shop";
    private final static String SHOP_FILE_PATH = "src/main/resources/files/xml/shops.xml";
    private final ShopRepository shopRepository;
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository, ModelMapper mapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOP_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder message = new StringBuilder();

        List<ShopSeedDto> shopSeedDtos = xmlParser.deserialize(ShopRootSeedDto.class, Path.of(SHOP_FILE_PATH).toFile()).getShops().stream().collect(Collectors.toList());
        for (ShopSeedDto shopSeedDto : shopSeedDtos) {

            if (!isExistShopWithName(shopSeedDto.getName()) && validationUtil.isValid(shopSeedDto)) {

                Shop shop = mapper.map(shopSeedDto, Shop.class);
                Town town = townRepository.getTownByName(shopSeedDto.getTown().getName());
                shop.setTown(town);

                shopRepository.save(shop);
                message.append(String.format(SUCCESSFUL_MESSAGE, shop.getName(), shop.getIncome()));
                message.append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE);
                message.append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistShopWithName(String name) {
        return shopRepository.findShopByName(name).isPresent();
    }
}
