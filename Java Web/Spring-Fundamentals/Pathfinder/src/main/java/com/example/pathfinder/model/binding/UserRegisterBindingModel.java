package com.example.pathfinder.model.binding;

import com.example.pathfinder.validation.FieldMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

// model from front-end
@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Password must match"
)
public class UserRegisterBindingModel {

    @Length(min = 2)
    private String username;

    @Length(min = 2, message = "Full name is too short")
    private String fullName;

    @Email(regexp = ".+@.+")
    private String email;

    @Positive
    private Integer age;

    @Length(min = 2)
    private String password;

    @Length(min = 2)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
