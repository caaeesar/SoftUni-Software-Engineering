package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.dao.CarRepository;
import bg.softuni.cardealer.dao.CustomerRepository;
import bg.softuni.cardealer.dao.SaleRepository;
import bg.softuni.cardealer.model.dto.exportDtos.SaleWithDiscountInfoDto;
import bg.softuni.cardealer.model.entity.Car;
import bg.softuni.cardealer.model.entity.Customer;
import bg.softuni.cardealer.model.entity.Sale;
import bg.softuni.cardealer.service.SaleService;
import bg.softuni.cardealer.utils.JsonWriterUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

import static bg.softuni.cardealer.constants.FilesPath.*;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepo;
    private final CarRepository carRepo;
    private final CustomerRepository customerRepo;
    private final Gson gson;

    private Random random = new Random();

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepo, CarRepository carRepo, CustomerRepository customerRepo, Gson gson) {
        this.saleRepo = saleRepo;
        this.carRepo = carRepo;
        this.customerRepo = customerRepo;
        this.gson = gson;
    }


    @Override
    public void seedSales() {
        if (this.saleRepo.count() > 0) {
            return;
        }
        // can have duplicate cars
        for (int i = 0; i < 3; i++) {
            Car car = getRandomCar();
            Customer customer = getRandomCustomer();
            double discount = getRandomDiscount();
            this.saleRepo.save(new Sale(car, customer, discount));
        }
    }

    @Override
    public void getSalesInfo() throws IOException {
        List<SaleWithDiscountInfoDto> dtos = this.saleRepo.getSalesWithCarsAndDiscountInfo();
        String jsonContent = this.gson.toJson(dtos);
        JsonWriterUtil.writeToJson(Collections.singletonList(jsonContent), Path.of(ROOT_OUT_FILE_PATH + SALES_INFO_FILE_PATH));
    }

    private double getRandomDiscount() {
        List<Integer> discounts = List.of(0, 5, 10, 15, 20, 30, 40, 50);
        int randomIndex = this.random.nextInt(discounts.size());
        return discounts.get(randomIndex);
    }

    private Customer getRandomCustomer() {
        long randomId = this.random.nextLong(this.customerRepo.count()) + 1;
        return this.customerRepo.findById(randomId).get();
    }

    private Car getRandomCar() {
        long randomId = this.random.nextLong(this.carRepo.count());
        return this.carRepo.findById(randomId).get();
    }
}
