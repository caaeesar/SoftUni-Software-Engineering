package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerSeedDto;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.ValidationUtil;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final static String SUCCESSFUL_MESSAGE = "Successfully imported Customer %s %s - %s";
    private final static String INVALID_MESSAGE = "Invalid Customer";
    private final static String CUSTOMER_FILE_PATH = "src/main/resources/files/json/customers.json";
    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, TownRepository townRepository, ModelMapper mapper, Gson gson, ValidationUtil validationUtil) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMER_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        Converter<String, LocalDate> stringToLocalDateConverter
                = context -> LocalDate.parse(context.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        mapper.typeMap(CustomerSeedDto.class, Customer.class)
                .addMappings(mapper -> mapper.using(stringToLocalDateConverter)
                        .map(CustomerSeedDto::getRegisteredOn, Customer::setRegisteredOn));


        StringBuilder message = new StringBuilder();

        List<CustomerSeedDto> customerSeedDtos = Arrays.stream(gson.fromJson(readCustomersFileContent(), CustomerSeedDto[].class)).collect(Collectors.toList());

        for (CustomerSeedDto customerSeedDto : customerSeedDtos) {

            if (!isExistCustomerWithEmail(customerSeedDto.getEmail()) && validationUtil.isValid(customerSeedDto)) {

                Customer customer = mapper.map(customerSeedDto, Customer.class);
                Town town = townRepository.getTownByName(customerSeedDto.getTown().getName());
                customer.setTown(town);

                customerRepository.save(customer);
                message.append(String.format(SUCCESSFUL_MESSAGE, customer.getFirstName(), customer.getLastName(), customer.getEmail()));
                message.append(System.lineSeparator());

            } else {
                message.append(INVALID_MESSAGE).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }

    private boolean isExistCustomerWithEmail(String email) {
        return customerRepository.findCustomerByEmail(email).isPresent();
    }
}
