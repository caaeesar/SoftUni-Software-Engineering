package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.dao.CustomerRepository;
import bg.softuni.cardealer.model.dto.exports.CustomerRootViewDto;
import bg.softuni.cardealer.model.dto.exports.CustomerRootWithSaleDto;
import bg.softuni.cardealer.model.dto.exports.CustomerViewDto;
import bg.softuni.cardealer.model.dto.exports.CustomerWithSaleDto;
import bg.softuni.cardealer.model.dto.imports.CustomerRootSeedDto;
import bg.softuni.cardealer.model.entity.Customer;
import bg.softuni.cardealer.service.CustomerService;
import bg.softuni.cardealer.utils.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static bg.softuni.cardealer.constants.FilePaths.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;
    private final XmlParser xmlParser;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper mapper, XmlParser xmlParser) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCustomers() throws JAXBException, FileNotFoundException {
        if (customerRepository.count() > 0) {
            return;
        }

        CustomerRootSeedDto rootSeedDto = xmlParser.deserialize(CustomerRootSeedDto.class, ROOT_IN_FILE_PATH + CUSTOMERS_FILE_NAME);
        rootSeedDto.getCustomers().stream()
                .map(customerSeedDto -> {
                    Customer customer = mapper.map(customerSeedDto, Customer.class);
                    customer.setBirthDate(LocalDateTime.parse(customerSeedDto.getBirthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
                    return customer;
                })
                .forEach(customerRepository::save);
    }

    @Override
    public void getOrderedCustomers() throws JAXBException {
        List<CustomerViewDto> customerViewDtos = customerRepository.getCustomersByOrderByBirthDateAscIsYoungDriverAsc()
                .stream()
                .map(customer -> {
                    CustomerViewDto customerViewDto = mapper.map(customer, CustomerViewDto.class);
                    customerViewDto.setBirthDate(customer.getBirthDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
                    return customerViewDto;})
                .toList();
        CustomerRootViewDto rootViewDto = new CustomerRootViewDto();
        rootViewDto.setCustomers(customerViewDtos);
        xmlParser.serialize(rootViewDto, ROOT_OUT_FILE_PATH + ORDERED_CUSTOMERS_FILE_NAME);
    }

    @Override
    public void getTotalSalesByCustomer() throws JAXBException {
        List<CustomerWithSaleDto> customersWithSalesInfo = customerRepository.getCustomersWithSalesInfo();
        CustomerRootWithSaleDto rootCustomer = new CustomerRootWithSaleDto();
        rootCustomer.setCustomers(customersWithSalesInfo);
        xmlParser.serialize(rootCustomer, ROOT_OUT_FILE_PATH + CUSTOMERS_AND_SALES_FILE_PATH);
    }
}
