package bg.softuni.automappingobjectslab.service;

import bg.softuni.automappingobjectslab.model.dto.EmployeeProjectionDto;
import bg.softuni.automappingobjectslab.model.dto.EmployeeSeedDto;
import bg.softuni.automappingobjectslab.model.dto.EmployeeViewDto;
import bg.softuni.automappingobjectslab.model.dto.ManagerDto;
import bg.softuni.automappingobjectslab.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void seedEmployee(EmployeeSeedDto employeeSeedDto);

    void seedEmployee(Employee employee);

    EmployeeViewDto getEmployeeByName(String name);

    List<ManagerDto> getAllManagers();

    void addSubordinates(Employee manager, List<Employee> subordinates);

    void deleteEmployee(Long id);

    List<EmployeeProjectionDto> getEmployeesBornBefore1990();

}
