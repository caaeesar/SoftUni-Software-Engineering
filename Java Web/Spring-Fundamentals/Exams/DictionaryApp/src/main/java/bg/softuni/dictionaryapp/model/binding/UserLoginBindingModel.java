package bg.softuni.dictionaryapp.model.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserLoginBindingModel {

    @NotBlank(message = "Username cannot be empty!")
    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    private String username;

    @NotBlank(message = "Password cannot be empty!")
    @Length(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String password;

}
