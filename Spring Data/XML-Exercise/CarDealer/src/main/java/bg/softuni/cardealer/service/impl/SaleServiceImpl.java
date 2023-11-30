package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.dao.CarRepository;
import bg.softuni.cardealer.dao.CustomerRepository;
import bg.softuni.cardealer.dao.SaleRepository;
import bg.softuni.cardealer.model.dto.exports.SaleRootWithDiscountInfoDto;
import bg.softuni.cardealer.model.dto.exports.SaleWithDiscountInfoDto;
import bg.softuni.cardealer.model.dto.exports.SaleWrapperDto;
import bg.softuni.cardealer.model.entity.Car;
import bg.softuni.cardealer.model.entity.Customer;
import bg.softuni.cardealer.model.entity.Sale;
import bg.softuni.cardealer.service.SaleService;
import bg.softuni.cardealer.utils.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Random;

import static bg.softuni.cardealer.constants.FilePaths.*;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;
    private final XmlParser xmlParser;
    private Random random = new Random();

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CustomerRepository customerRepository, CarRepository carRepository, XmlParser xmlParser) {
        this.saleRepository = saleRepository;
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedSales() {
        if (saleRepository.count() > 0) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            Car car = getRandomCar();
            Customer customer = getRandomCustomer();
            double discount = getRandomDiscount();
            this.saleRepository.save(new Sale(car, customer, discount));
        }
    }

    @Override
    public void getSalesInfo() throws JAXBException {
        List<SaleWrapperDto> saleWrapperDtos = saleRepository.getSalesWithCarsAndDiscountInfo()
                .stream().map(SaleWithDiscountInfoDto::createSaleWrapper)
                .toList();
        SaleRootWithDiscountInfoDto rootSale = new SaleRootWithDiscountInfoDto();
        rootSale.setSales(saleWrapperDtos);
        xmlParser.serialize(rootSale, ROOT_OUT_FILE_PATH + SALES_INFO_FILE_PATH);
    }

    private double getRandomDiscount() {
        List<Integer> discounts = List.of(0, 5, 10, 15, 20, 30, 40, 50);
        int randomIndex = random.nextInt(discounts.size());
        return discounts.get(randomIndex);
    }

    private Customer getRandomCustomer() {
        long randomId = this.random.nextLong(customerRepository.count()) + 1;
        return customerRepository.findById(randomId).get();
    }

    private Car getRandomCar() {
        long randomId = random.nextLong(carRepository.count());
        return carRepository.findById(randomId).get();
    }
}
