package com.example.resellerapp.model.view;

import com.example.resellerapp.model.entity.enums.ConditionName;

import java.math.BigDecimal;

public class OtherOffersViewModel {

    private String id;
    private String sellerName;
    private String description;
    private ConditionName condition;
    private BigDecimal price;

    public OtherOffersViewModel(String id, String sellerName, String description, ConditionName condition, BigDecimal price) {
        this.id = id;
        this.sellerName = sellerName;
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

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
