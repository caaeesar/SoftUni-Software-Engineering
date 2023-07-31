package bg.softuni.automappingobjectslab.service.impl;

import bg.softuni.automappingobjectslab.dao.EmployeeRepository;
import bg.softuni.automappingobjectslab.model.dto.EmployeeProjectionDto;
import bg.softuni.automappingobjectslab.model.dto.EmployeeSeedDto;
import bg.softuni.automappingobjectslab.model.dto.EmployeeViewDto;
import bg.softuni.automappingobjectslab.model.dto.ManagerDto;
import bg.softuni.automappingobjectslab.model.entity.Employee;
import bg.softuni.automappingobjectslab.service.EmployeeService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo, ModelMapper mapper) {
        this.employeeRepo = employeeRepo;
        this.mapper = mapper;
    }


    @Override
    public void seedEmployee(EmployeeSeedDto employeeSeedDto) {
        // Simple Mapping -> mapping DTO to Entity by matching names
        this.employeeRepo.save(this.mapper.map(employeeSeedDto, Employee.class));
    }

    @Override
    public void seedEmployee(Employee employee) {
        this.employeeRepo.saveAndFlush(employee);
    }

    @Override
    public EmployeeViewDto getEmployeeByName(String name) {
        // Custom mapping, because names is different
        // manually mapping Entity to DTO
        Employee employee = this.employeeRepo.getEmployeeByFirstName(name);
     /*   // first way                      // Destination  // Source
        this.mapper.addMappings(new PropertyMap<Employee, EmployeeViewDto>() {
            @Override
            protected void configure() {
                map().setCity(source.getAddress().getCity().getName());
            }
        });
       return this.mapper.map(employee, EmployeeViewDto.class);*/
        // second way
        TypeMap<Employee, EmployeeViewDto> typeMap = this.mapper.createTypeMap(Employee.class, EmployeeViewDto.class);
        typeMap.addMappings(m -> m.map(source -> source.getAddress().getCity().getName(), EmployeeViewDto::setCity));
        return typeMap.map(employee);
    }

    @Override
    public List<ManagerDto> getAllManagers() {
        List<Employee> managers = this.employeeRepo.getEmployeesByManagerNull();
        return managers.stream().map(manager -> mapper.map(manager, ManagerDto.class)).collect(Collectors.toList());
    }

    @Override
    public void addSubordinates(Employee manager, List<Employee> subordinates) {
        manager.setSubordinates(subordinates);
        this.employeeRepo.saveAndFlush(manager);
    }


    @Override
    public void deleteEmployee(Long id) {
        Employee removed = this.employeeRepo.getEmployeeById(id);
        if (removed.getManager() != null) {
            // remove from the manager subordinates list
            removed.getManager().getSubordinates().remove(removed);
        }
        this.employeeRepo.deleteEmployeeById(id);
    }

    @Override
    public List<EmployeeProjectionDto> getEmployeesBornBefore1990() {
        List<Employee> employees = this.employeeRepo.getEmployeesByBirthdayBefore(LocalDate.of(1990, 1, 1));
        this.mapper.map(Employee.class, EmployeeProjectionDto.class);
        /*Converter<String, String> converterNoManager = ctx -> ctx.getSource() == null ? "[No manager]" : ctx.getSource();
        mapper.addConverter(converterNoManager);*/
        return employees.stream().map(employee -> mapper.map(employee, EmployeeProjectionDto.class)).collect(Collectors.toList());
    }

}
