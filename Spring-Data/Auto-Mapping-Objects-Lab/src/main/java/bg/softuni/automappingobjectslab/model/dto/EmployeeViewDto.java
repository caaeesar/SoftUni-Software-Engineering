package bg.softuni.automappingobjectslab.model.dto;

import java.math.BigDecimal;

public class EmployeeViewDto {
    private String firstName;
    private String lastName;
    private BigDecimal salary;

    private String city;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("    - %s %s %s from %s", this.firstName,this.lastName,this.salary, this.city);
    }
}
