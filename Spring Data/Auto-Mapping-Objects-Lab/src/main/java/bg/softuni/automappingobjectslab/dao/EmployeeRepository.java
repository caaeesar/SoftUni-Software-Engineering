package bg.softuni.automappingobjectslab.dao;

import bg.softuni.automappingobjectslab.model.dto.EmployeeProjectionDto;
import bg.softuni.automappingobjectslab.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee getEmployeeByFirstName(String name);

    List<Employee> getEmployeesByManagerNull();

    void deleteEmployeeById(Long id);

    Employee getEmployeeById(Long id);

    List<Employee> getEmployeesByBirthdayBefore(LocalDate birthday);

}
