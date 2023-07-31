package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.dao.SupplierRepository;
import bg.softuni.cardealer.model.dto.exports.SupplierNotImporterDto;
import bg.softuni.cardealer.model.dto.exports.SupplierRootNotImporterDto;
import bg.softuni.cardealer.model.dto.imports.SupplierRootSeedDto;
import bg.softuni.cardealer.model.entity.Supplier;
import bg.softuni.cardealer.service.SupplierService;
import bg.softuni.cardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

import static bg.softuni.cardealer.constants.FilePaths.*;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper mapper, XmlParser xmlParser) {
        this.supplierRepository = supplierRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedSuppliers() throws JAXBException, FileNotFoundException {
        if (supplierRepository.count() > 0) {
            return;
        }
        SupplierRootSeedDto rootSeedDto = xmlParser.deserialize(SupplierRootSeedDto.class, ROOT_IN_FILE_PATH + SUPPLIERS_FILE_NAME);
        rootSeedDto.getSuppliers().stream()
                .map(supplierSeedDto -> mapper.map(supplierSeedDto, Supplier.class))
                .forEach(supplierRepository::save);
    }

    @Override
    public void getSuppliersWhichNotImportedParts() throws JAXBException {
        List<SupplierNotImporterDto> supplierNotImporterDtos = supplierRepository.getSuppliersByIsImporterIsFalse()
                .stream()
                .map(supplier -> {
                    SupplierNotImporterDto supplierDto = mapper.map(supplier, SupplierNotImporterDto.class);
                    supplierDto.setPartsCount(supplier.getPartsCount());
                    return supplierDto;
                })
                .toList();
        SupplierRootNotImporterDto rootDto = new SupplierRootNotImporterDto();
        rootDto.setSuppliers(supplierNotImporterDtos);
        xmlParser.serialize(rootDto, ROOT_OUT_FILE_PATH + LOCAL_SUPPLIER_FILE_PATH);
    }
}
