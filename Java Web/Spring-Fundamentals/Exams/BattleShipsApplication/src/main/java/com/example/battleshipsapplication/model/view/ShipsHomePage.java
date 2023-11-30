package com.example.battleshipsapplication.model.view;

import java.util.List;

public class ShipsHomePage {

    List<ShipsAttackerViewModel> shipsAttacker;

    List<ShipsDefenderViewModel> shipsDefender;

    List<ShipsWithStatusViewModel> allShipsStatus;

    public ShipsHomePage() {
    }

    public ShipsHomePage(List<ShipsAttackerViewModel> shipsAttacker, List<ShipsDefenderViewModel> shipsDefender, List<ShipsWithStatusViewModel> allShipsStatus) {
        this.shipsAttacker = shipsAttacker;
        this.shipsDefender = shipsDefender;
        this.allShipsStatus = allShipsStatus;
    }

    public List<ShipsAttackerViewModel> getShipsAttacker() {
        return shipsAttacker;
    }

    public void setShipsAttacker(List<ShipsAttackerViewModel> shipsAttacker) {
        this.shipsAttacker = shipsAttacker;
    }

    public List<ShipsDefenderViewModel> getShipsDefender() {
        return shipsDefender;
    }

    public void setShipsDefender(List<ShipsDefenderViewModel> shipsDefender) {
        this.shipsDefender = shipsDefender;
    }

    public List<ShipsWithStatusViewModel> getAllShipsStatus() {
        return allShipsStatus;
    }

    public void setAllShipsStatus(List<ShipsWithStatusViewModel> allShipsStatus) {
        this.allShipsStatus = allShipsStatus;
    }
}
