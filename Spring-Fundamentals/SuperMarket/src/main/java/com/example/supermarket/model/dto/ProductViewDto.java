package com.example.supermarket.model.dto;

import java.math.BigDecimal;

public class ProductViewDto {

    private String name;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s - %s $", this.name, this.price);
    }
}
