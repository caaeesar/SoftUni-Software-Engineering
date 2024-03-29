package com.example.pathfinder.model.view;

import com.example.pathfinder.model.entity.enums.UserLevel;

public class UserViewModel {

    private UserLevel level;

    private String fullName;

    private String username;

    private Integer age;

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
