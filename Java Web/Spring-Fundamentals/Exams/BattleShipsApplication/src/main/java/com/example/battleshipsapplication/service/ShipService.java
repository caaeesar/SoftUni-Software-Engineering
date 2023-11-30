package com.example.battleshipsapplication.service;

import com.example.battleshipsapplication.model.binding.BattleShipsBindingModel;
import com.example.battleshipsapplication.model.binding.ShipAddBindingModel;
import com.example.battleshipsapplication.model.view.ShipsHomePage;

public interface ShipService {
    boolean addShip(ShipAddBindingModel shipAddBindingModel);

    ShipsHomePage findShipsForHomePage();

    void battle(BattleShipsBindingModel battleShipsBindingModel);
}
