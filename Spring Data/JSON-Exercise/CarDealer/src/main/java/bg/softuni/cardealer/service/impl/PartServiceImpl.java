package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.dao.PartRepository;
import bg.softuni.cardealer.dao.SupplierRepository;
import bg.softuni.cardealer.model.dto.importDtos.PartSeedDto;
import bg.softuni.cardealer.model.entity.Part;
import bg.softuni.cardealer.model.entity.Supplier;
import bg.softuni.cardealer.service.PartService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static bg.softuni.cardealer.constants.FilesPath.*;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepo;
    private final SupplierRepository supplierRepo;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public PartServiceImpl(PartRepository partRepo, SupplierRepository supplierRepo, Gson gson, ModelMapper modelMapper) {
        this.partRepo = partRepo;
        this.supplierRepo = supplierRepo;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedParts() throws IOException {
        String fileContent = Files.readString(Path.of(ROOT_IN_FILE_PATH + PARTS_FILE_NAME));
        PartSeedDto[] dtos = this.gson.fromJson(fileContent, PartSeedDto[].class);

        List<Part> parts = Arrays.stream(dtos)
                .map(partSeedDto -> this.modelMapper.map(partSeedDto, Part.class))
                .toList();
        for (int i = 0; i < parts.size(); i++) {
            Supplier supplier = getRandomSupplier();
            parts.get(i).setSupplier(supplier);
            // bidirectional relation
           // supplier.getParts().add(parts.get(i));
        }
        this.partRepo.saveAll(parts);
    }

    private Supplier getRandomSupplier() {
        Random rnd = new Random();
        long randomId = rnd.nextLong(this.supplierRepo.count()) + 1;
        return this.supplierRepo.findById(randomId).get();
    }
}
