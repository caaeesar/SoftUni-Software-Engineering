package bg.softuni.likebookapp.model.binding;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserLoginBindingModel {

    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters ")
    @NotBlank
    private String username;

    @Length(min = 3, max = 20, message = "Email cannot be empty")
    @NotBlank
    private String password;

}
