package com.example.resellerapp.model.view;

import com.example.resellerapp.model.entity.enums.ConditionName;

import java.math.BigDecimal;

public class MyOffersViewModel {

    private String id;
    private String description;
    private ConditionName condition;
    private BigDecimal price;

    public MyOffersViewModel(String id, String description, ConditionName condition, BigDecimal price) {
        this.id = id;
        this.description = description;
        this.condition = condition;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ConditionName getCondition() {
        return condition;
    }

    public void setCondition(ConditionName condition) {
        this.condition = condition;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
