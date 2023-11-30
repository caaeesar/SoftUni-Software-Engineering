package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.dao.PartRepository;
import bg.softuni.cardealer.dao.SupplierRepository;
import bg.softuni.cardealer.model.dto.imports.PartRootSeedDto;
import bg.softuni.cardealer.model.entity.Part;
import bg.softuni.cardealer.model.entity.Supplier;
import bg.softuni.cardealer.service.PartService;
import bg.softuni.cardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

import static bg.softuni.cardealer.constants.FilePaths.*;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, SupplierRepository supplierRepository, ModelMapper mapper, XmlParser xmlParser) {
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedParts() throws JAXBException, FileNotFoundException {
        if (partRepository.count() > 0) {
            return;
        }
        PartRootSeedDto rootSeedDto = xmlParser.deserialize(PartRootSeedDto.class, ROOT_IN_FILE_PATH + PARTS_FILE_NAME);
        List<Part> parts = rootSeedDto.getParts().stream()
                .map(partSeedDto -> mapper.map(partSeedDto, Part.class))
                .toList();
        for (int i = 0; i < parts.size(); i++) {
            Supplier supplier = getRandomSupplier();
            parts.get(i).setSupplier(supplier);
        }
        partRepository.saveAll(parts);
    }

    private Supplier getRandomSupplier() {
        Random rnd = new Random();
        long randomId = rnd.nextLong(supplierRepository.count()) + 1;
        return supplierRepository.findById(randomId).get();
    }
}
