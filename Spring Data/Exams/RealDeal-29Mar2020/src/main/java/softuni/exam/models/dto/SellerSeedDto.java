package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;
import softuni.exam.models.entity.enums.Rating;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SellerSeedDto {

    @XmlElement(name = "first-name")
    @Length(min = 2, max = 19)
    private String firstName;

    @XmlElement(name = "last-name")
    @Length(min = 2, max = 19)
    private String lastName;

    @XmlElement
    @Email
    private String email;

    @XmlElement
    @NotNull
    private Rating rating;

    @XmlElement
    @NotNull
    private String town;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
