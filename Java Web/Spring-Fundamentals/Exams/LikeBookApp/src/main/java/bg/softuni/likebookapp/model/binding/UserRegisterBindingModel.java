package bg.softuni.likebookapp.model.binding;

import bg.softuni.likebookapp.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@FieldMatch(
        first = "password",
        second = "confirmPassword"
)
@Getter
@Setter
public class UserRegisterBindingModel {

    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters ")
    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    @Length(min = 3, max = 20, message = "Email cannot be empty")
    @NotBlank
    private String password;

    @Length(min = 3, max = 20, message = "Email cannot be empty")
    @NotBlank
    private String confirmPassword;

}
