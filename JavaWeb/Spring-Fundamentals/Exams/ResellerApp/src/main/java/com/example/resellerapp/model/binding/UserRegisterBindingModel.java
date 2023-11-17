package com.example.resellerapp.model.binding;

import com.example.resellerapp.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Password must match"
)
public class UserRegisterBindingModel {

    @NotNull
    @Length(min = 3, max = 20)
    private String username;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Length(min = 3, max = 20)
    private String password;

    @NotNull
    @Length(min = 3, max = 20)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
