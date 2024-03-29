package bg.softuni.coffeeshopapplication.model.binding;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class UserLoginBindingModel {
    @NotNull
    @NotEmpty
    @Length(min = 5, max = 20)
    private String username;

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
