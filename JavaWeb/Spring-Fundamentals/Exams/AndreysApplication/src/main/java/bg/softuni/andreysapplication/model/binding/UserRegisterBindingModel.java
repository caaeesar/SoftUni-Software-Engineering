package bg.softuni.andreysapplication.model.binding;

import bg.softuni.andreysapplication.validation.FieldMatch;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Password must match"
)
@Getter
@Setter
public class UserRegisterBindingModel {

    @NotBlank
    @Length(min = 2, message = "Username length must be more than two characters")
    private String username;

    @Email
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @PositiveOrZero(message = "Budget must be or equal to 0!")
    @NotNull
    private BigDecimal budget;

    @NotBlank
    @Length(min = 2, message = "Password length must be more than two characters")
    private String password;

    @NotBlank
    @Length(min = 2, message = "Password length must be more than two characters")
    private String confirmPassword;
}
