package bg.softuni.andreysapplication.model.binding;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserLoginBindingModel {

    @NotBlank
    @Length(min = 2, message = "Username length must be more than two characters")
    private String username;

    @NotBlank
    @Length(min = 2, message = "Password length must be more than two characters")
    private String password;
}
