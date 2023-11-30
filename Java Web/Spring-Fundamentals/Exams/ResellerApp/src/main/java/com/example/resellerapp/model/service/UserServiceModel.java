package com.example.resellerapp.model.service;

import com.example.resellerapp.model.entity.Offer;


import java.util.Set;

public class UserServiceModel {

    private String username;

    private Set<Offer> offers;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

}
