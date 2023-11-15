package bg.softuni.plannerapp.model.binding;

import bg.softuni.plannerapp.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Password must match!"
)
@Getter
@Setter
public class UserRegisterBindingModel {

    @NotBlank(message = "Username cannot be empty!")
    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    private String username;

    @Email
    @NotBlank(message = "Email cannot be empty!")
    private String email;

    @NotBlank(message = "Password cannot be empty!")
    @Length(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    private String password;

    @NotBlank(message = "Password cannot be empty!")
    @Length(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    private String confirmPassword;
}
