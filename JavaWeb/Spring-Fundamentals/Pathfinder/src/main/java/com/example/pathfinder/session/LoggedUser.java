package com.example.pathfinder.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope // not singleton instance
public class LoggedUser {

    private Long id;

    private String username;

    private boolean isLogged;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
    public void reset() {
        setId(null);
        setUsername(null);
        setLogged(false);
    }

}
