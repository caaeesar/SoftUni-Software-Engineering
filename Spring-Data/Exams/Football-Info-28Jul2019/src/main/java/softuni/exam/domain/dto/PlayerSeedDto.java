package softuni.exam.domain.dto;

import org.hibernate.validator.constraints.Length;
import softuni.exam.domain.entities.enums.Position;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class PlayerSeedDto {

    @NotNull
    private String firstName;

    @NotNull
    @Length(min = 3, max = 15)
    private String lastName;

    @NotNull
    @Min(value = 1)
    @Max(value = 99)
    private Integer number;

    @NotNull
    @PositiveOrZero
    private BigDecimal salary;

    @NotNull
    private Position position;
    private PictureUrlDto picture;
    private TeamWithNameAndPicture team;

    public TeamWithNameAndPicture getTeam() {
        return team;
    }

    public void setTeam(TeamWithNameAndPicture team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

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

    public PictureUrlDto getPicture() {
        return picture;
    }

    public void setPicture(PictureUrlDto picture) {
        this.picture = picture;
    }
}
