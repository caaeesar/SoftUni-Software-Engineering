package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.dao.SupplierRepository;
import bg.softuni.cardealer.model.dto.exportDtos.SupplierNotImporterDto;
import bg.softuni.cardealer.model.dto.importDtos.SupplierSeedDto;
import bg.softuni.cardealer.model.entity.Supplier;
import bg.softuni.cardealer.service.SupplierService;
import bg.softuni.cardealer.utils.JsonWriterUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static bg.softuni.cardealer.constants.FilesPath.*;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepo;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepo, Gson gson, ModelMapper modelMapper) {
        this.supplierRepo = supplierRepo;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliers() throws IOException {
        if (this.supplierRepo.count() > 0) {
            return;
        }
        String fileContent = Files.readString(Path.of(ROOT_IN_FILE_PATH + SUPPLIERS_FILE_NAME));
        SupplierSeedDto[] dtos = this.gson.fromJson(fileContent, SupplierSeedDto[].class);
        Arrays.stream(dtos)
                .map(supplierSeedDto -> this.modelMapper.map(supplierSeedDto, Supplier.class))
                .forEach(this.supplierRepo::save);
    }

    @Override
    public void getSuppliersWhichNotImportedParts() throws IOException {
        TypeMap<Supplier, SupplierNotImporterDto> typeMap = this.modelMapper.createTypeMap(Supplier.class, SupplierNotImporterDto.class)
                .addMappings(mapper -> mapper.map(Supplier::getPartsCount, SupplierNotImporterDto::setPartsCount));
        List<SupplierNotImporterDto> dtos = this.supplierRepo.getSuppliersByIsImporterIsFalse()
                .stream()
                .map(typeMap::map)
                .toList();
        String jsonContent = this.gson.toJson(dtos);
        JsonWriterUtil.writeToJson(Collections.singletonList(jsonContent), Path.of(ROOT_OUT_FILE_PATH + LOCAL_SUPPLIER_FILE_PATH));
    }
}
