package com.example.mobilelelewebapplication.model.dto;

import com.example.mobilelelewebapplication.model.entity.enums.RoleType;
import jakarta.validation.constraints.NotNull;

public class UserRegistrationDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String username;

    @NotNull
    private String password;

    private RoleType role;

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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
