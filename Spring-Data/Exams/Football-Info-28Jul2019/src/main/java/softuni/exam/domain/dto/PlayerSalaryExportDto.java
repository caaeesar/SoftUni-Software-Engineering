package softuni.exam.domain.dto;


import java.math.BigDecimal;

public class PlayerSalaryExportDto {

    private String firstName;
    private String lastName;
    private Integer number;
    private BigDecimal salary;
    private String teamName;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        String format = "Player name: %s %s \n" +
                " Number: %d\n" +
                " Salary: %s\n" +
                " Team: %s";
        return String.format(format, getFirstName(), getLastName(), getNumber(), getSalary().setScale(2), getTeamName());
    }
}
