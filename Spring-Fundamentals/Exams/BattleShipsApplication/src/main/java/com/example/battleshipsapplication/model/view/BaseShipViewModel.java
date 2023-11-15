package com.example.battleshipsapplication.model.view;

public class BaseShipViewModel {

    private String id;

    private String name;

    private Integer health;

    private Integer power;

    public BaseShipViewModel(String id, String name, Integer health, Integer power) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.power = power;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}
