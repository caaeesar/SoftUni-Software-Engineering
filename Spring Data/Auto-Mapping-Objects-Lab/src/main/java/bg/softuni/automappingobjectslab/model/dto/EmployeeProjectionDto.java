package bg.softuni.automappingobjectslab.model.dto;

import java.math.BigDecimal;

public class EmployeeProjectionDto {

    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private ManagerDto manager;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public ManagerDto getManager() {
        return manager;
    }

    public void setManager(ManagerDto manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        String manager = this.manager != null ? this.manager.getLastName() : "[No manager]";
        return String.format("%s %s %s – Manager: %s", this.firstName, this.lastName, this.salary, manager);
    }
}
