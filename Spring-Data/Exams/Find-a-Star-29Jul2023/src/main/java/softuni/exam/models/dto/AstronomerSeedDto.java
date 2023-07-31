package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerSeedDto {

    @XmlElement(name = "average_observation_hours")
    @NotNull
    @DecimalMin(value = "500.00")
    private Double averageObservationHours;

    @XmlElement
    private String birthday;

    @XmlElement(name = "first_name")
    @NotNull
    @Length(min = 2, max = 30)
    private String firstName;

    @XmlElement(name = "last_name")
    @NotNull
    @Length(min = 2, max = 30)
    private String lastName;

    @XmlElement
    @NotNull
    @DecimalMin(value = "15000.00")
    private Double salary;

    @XmlElement(name = "observing_star_id")
    private Long observingStar;

    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getObservingStar() {
        return observingStar;
    }

    public void setObservingStar(Long observingStar) {
        this.observingStar = observingStar;
    }
}
