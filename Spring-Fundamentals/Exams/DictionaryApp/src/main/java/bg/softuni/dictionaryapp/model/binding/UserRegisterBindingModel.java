package bg.softuni.dictionaryapp.model.binding;

import bg.softuni.dictionaryapp.validation.FieldMatch;
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

    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    @NotBlank(message = "Username cannot be empty!")
    private String username;

    @NotBlank(message = "Email cannot be empty!")
    @Email
    private String email;

    @Length(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    @NotBlank(message = "Password cannot be empty!")
    private String password;


    @Length(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    @NotBlank(message = "Confirm password cannot be empty!")
    private String confirmPassword;
}
