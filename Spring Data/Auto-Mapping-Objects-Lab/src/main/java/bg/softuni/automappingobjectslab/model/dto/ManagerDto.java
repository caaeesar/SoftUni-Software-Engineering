package bg.softuni.automappingobjectslab.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerDto {

    private String firstName;
    private String lastName;
    private List<EmployeeViewDto> subordinates = new ArrayList<>();

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

    public List<EmployeeViewDto> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<EmployeeViewDto> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        final StringBuilder out = new StringBuilder();
        out.append(firstName).append(" ").append(lastName).append(" | ").append("Employees ");
        out.append(this.subordinates.size()).append(System.lineSeparator());
        out.append(subordinates.stream().map(EmployeeViewDto::toString).collect(Collectors.joining("\n")));
        return out.toString();
    }
}
