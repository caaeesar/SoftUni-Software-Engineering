package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.model.dto.exportDtos.CustomerWithSalesDto;
import bg.softuni.cardealer.utils.JsonWriterUtil;
import bg.softuni.cardealer.dao.CustomerRepository;
import bg.softuni.cardealer.model.dto.exportDtos.CustomerOrderedDto;
import bg.softuni.cardealer.model.dto.importDtos.CustomerSeedDto;
import bg.softuni.cardealer.model.entity.Customer;
import bg.softuni.cardealer.service.CustomerService;
import com.google.gson.Gson;
import org.hibernate.mapping.Collection;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static bg.softuni.cardealer.constants.FilesPath.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepo;

    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepo, ModelMapper modelMapper, /*@Qualifier(value = "withAdapter")*/ Gson gson) {
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedCustomers() throws IOException {
        if (this.customerRepo.count() > 0) {
            return;
        }
        Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> context) {
                return LocalDate.parse(context.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
        };
        TypeMap<CustomerSeedDto, Customer> typeMap = this.modelMapper.createTypeMap(CustomerSeedDto.class, Customer.class);
        typeMap.addMappings(mapper -> mapper.using(localDateConverter).map(CustomerSeedDto::getBirthDate, Customer::setBirthDate));

        String fileContent = Files.readString(Path.of(ROOT_IN_FILE_PATH + CUSTOMERS_FILE_NAME));
        CustomerSeedDto[] dtos = this.gson.fromJson(fileContent, CustomerSeedDto[].class);
        Arrays.stream(dtos).map(typeMap::map)
                .forEach(this.customerRepo::save);
    }

    @Override
    public void getOrderedCustomers() throws IOException {
        List<CustomerOrderedDto> dtos = this.customerRepo.getCustomersByOrderByBirthDateAscIsYoungDriverAsc()
                .stream()
                .map(customer -> this.modelMapper.map(customer, CustomerOrderedDto.class))
                .toList();

        String jsonContent = this.gson.toJson(dtos);
        JsonWriterUtil.writeToJson(Collections.singletonList(jsonContent), Path.of(ROOT_OUT_FILE_PATH + ORDERED_CUSTOMERS_FILE_NAME));
    }

    @Override
    public void getTotalSalesByCustomer() throws IOException {
        List<CustomerWithSalesDto> dtos = this.customerRepo.getCustomersWithSalesInfo();
        String jsonContent = this.gson.toJson(dtos);
        JsonWriterUtil.writeToJson(Collections.singletonList(jsonContent), Path.of(ROOT_OUT_FILE_PATH + CUSTOMERS_AND_SALES_FILE_PATH));
    }
}
