package com.example.resellerapp.model.view;

import java.math.BigDecimal;

public class BoughtOffersViewModel {

    private String description;

    private BigDecimal price;

    public BoughtOffersViewModel(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
