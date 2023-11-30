package exam.model.dto;

import javax.validation.constraints.*;

public class CustomerSeedDto {

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 2)
    private String firstName;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 2)
    private String lastName;

    @NotNull
    @NotBlank
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotBlank
    @NotEmpty
    private String registeredOn;

    private TownNameDto town;

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

    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }

    public TownNameDto getTown() {
        return town;
    }

    public void setTown(TownNameDto town) {
        this.town = town;
    }
}
