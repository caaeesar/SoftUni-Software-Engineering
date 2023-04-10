package DefiningClasses.exercises._02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department(String departmentName) {
        this.name = departmentName;
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public String getName() {
        return this.name;
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

}
