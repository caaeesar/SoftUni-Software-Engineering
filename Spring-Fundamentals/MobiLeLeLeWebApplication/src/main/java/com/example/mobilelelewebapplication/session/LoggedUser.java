package com.example.mobilelelewebapplication.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {

    private Long id;

    private String firstName;

    private String username;

    private boolean isLogged;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLogged() {
        return isLogged;
    }
    public void setLogged(boolean logged) {
        isLogged = logged;
    }


    public void reset() {
        setFirstName(null);
        setId(null);
        setLogged(false);
    }

}
