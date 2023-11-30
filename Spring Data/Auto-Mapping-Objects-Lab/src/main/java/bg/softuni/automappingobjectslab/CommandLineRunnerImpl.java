package bg.softuni.automappingobjectslab;

import bg.softuni.automappingobjectslab.model.dto.EmployeeProjectionDto;
import bg.softuni.automappingobjectslab.model.dto.EmployeeSeedDto;
import bg.softuni.automappingobjectslab.model.entity.Address;
import bg.softuni.automappingobjectslab.model.entity.City;
import bg.softuni.automappingobjectslab.model.entity.Employee;
import bg.softuni.automappingobjectslab.service.AddressService;
import bg.softuni.automappingobjectslab.service.CityService;
import bg.softuni.automappingobjectslab.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final CityService cityService;
    private final AddressService addressService;

    @Autowired
    public CommandLineRunnerImpl(EmployeeService employeeService, CityService cityService, AddressService addressService) {
        this.employeeService = employeeService;
        this.cityService = cityService;
        this.addressService = addressService;
    }

    @Override
    public void run(String... args) throws Exception {

        // 1.1
    /*    EmployeeSeedDto employeeSeedDto = new EmployeeSeedDto("Melissa", "Rudeva", BigDecimal.ZERO);
        this.employeeService.seedEmployee(employeeSeedDto);

        // 1.2
        City city = new City("Sofia");
        this.cityService.seedCity(city);
        Address address = new Address(city);
        this.addressService.seedAddress(address);
        Employee employee = new Employee("George", address);
        this.employeeService.seedEmployee(employee);
        System.out.println(this.employeeService.getEmployeeByName("George"));*/

        // 2

        City city = new City("Sofia");
        this.cityService.seedCity(city);
        Address address = new Address(city);
        this.addressService.seedAddress(address);

        Employee manager = new Employee("Test", "Testov");
        this.employeeService.seedEmployee(manager);
        Employee first = new Employee("Ivan", "Ivanov", BigDecimal.TEN, LocalDate.of(1980, 1,2),address, manager);
        this.employeeService.seedEmployee(first);
        Employee second = new Employee("Petar","Petrov",BigDecimal.TEN,LocalDate.of(1981, 3,4),address,null);
        this.employeeService.seedEmployee(second);
        Employee third = new Employee("Aleks", "Dimitrov",BigDecimal.TEN,LocalDate.of(1991, 5,6),address, manager);
        this.employeeService.seedEmployee(third);
        manager.setSubordinates(List.of(first, second, third));

        //System.out.println(this.employeeService.getAllManagers());

        this.employeeService.getEmployeesBornBefore1990().forEach(e -> System.out.println(e.toString()));

    }
}
