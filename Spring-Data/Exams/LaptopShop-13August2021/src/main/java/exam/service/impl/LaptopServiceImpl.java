package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.LaptopExportDto;
import exam.model.dto.LaptopSeedDto;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaptopServiceImpl implements LaptopService {

    private final static String SUCCESSFUL_MESSAGE = "Successfully imported Laptop %s - %.2f - %d - 128";
    private final static String INVALID_MESSAGE = "Invalid Laptop";
    private final static String LAPTOP_FILE_PATH = "src/main/resources/files/json/laptops.json";
    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOP_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder message = new StringBuilder();

        List<LaptopSeedDto> laptopSeedDtos = Arrays.stream(gson.fromJson(readLaptopsFileContent(), LaptopSeedDto[].class)).collect(Collectors.toList());
        for (LaptopSeedDto laptopSeedDto : laptopSeedDtos) {

            if (!isExistLaptopWithMacAddress(laptopSeedDto.getMacAddress()) && validationUtil.isValid(laptopSeedDto)) {
                Laptop laptop = mapper.map(laptopSeedDto, Laptop.class);
                Shop shop = shopRepository.getShopByName(laptopSeedDto.getShop().getName());
                laptop.setShop(shop);
                laptopRepository.save(laptop);
                message.append(String.format(SUCCESSFUL_MESSAGE, laptop.getMacAddress(), laptop.getCpuSpeed(), laptop.getRam()));
                message.append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistLaptopWithMacAddress(String macAddress) {
        return laptopRepository.findLaptopByMacAddress(macAddress).isPresent();
    }

    @Override
    public String exportBestLaptops() {
        return laptopRepository.getLaptopsByOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc()
                .stream().map(laptop -> mapper.map(laptop, LaptopExportDto.class))
                .map(LaptopExportDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
