package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class PassengerSeedDto {

    @Expose
    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 2)
    private String firstName;

    @Expose
    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 2)
    private String lastName;

    @Expose
    @NotNull
    @Positive
    private Integer age;

    @Expose
    @NotNull
    @NotBlank
    @NotEmpty
    private String phoneNumber;

    @Expose
    @NotNull
    @NotBlank
    @NotEmpty
    @Email
    private String email;

    @Expose
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
