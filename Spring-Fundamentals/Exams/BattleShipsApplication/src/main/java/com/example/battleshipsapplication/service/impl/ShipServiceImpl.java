package com.example.battleshipsapplication.service.impl;

import com.example.battleshipsapplication.model.binding.BattleShipsBindingModel;
import com.example.battleshipsapplication.model.binding.ShipAddBindingModel;
import com.example.battleshipsapplication.model.entity.Ship;
import com.example.battleshipsapplication.model.entity.User;
import com.example.battleshipsapplication.model.view.ShipsAttackerViewModel;
import com.example.battleshipsapplication.model.view.ShipsDefenderViewModel;
import com.example.battleshipsapplication.model.view.ShipsHomePage;
import com.example.battleshipsapplication.model.view.ShipsWithStatusViewModel;
import com.example.battleshipsapplication.repository.CategoryRepository;
import com.example.battleshipsapplication.repository.ShipRepository;
import com.example.battleshipsapplication.repository.UserRepository;
import com.example.battleshipsapplication.service.ShipService;
import com.example.battleshipsapplication.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;

    @Autowired
    public ShipServiceImpl(ShipRepository shipRepository, UserRepository userRepository, CategoryRepository categoryRepository, LoggedUser loggedUser, ModelMapper modelMapper) {
        this.shipRepository = shipRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean addShip(ShipAddBindingModel shipAddBindingModel) {
        Optional<Ship> optionalShipByName = shipRepository.findShipByName(shipAddBindingModel.getName());
        if (optionalShipByName.isPresent()) {
            return false;
        }
        User user = userRepository.findUserByUsername(loggedUser.getUsername()).get();
        Ship ship = modelMapper.map(shipAddBindingModel, Ship.class);
        ship.setOwn(user);
        ship.setCategory(categoryRepository.getCategoryByName(shipAddBindingModel.getCategory()));
        shipRepository.save(ship);
        return true;
    }

    @Override
    public ShipsHomePage findShipsForHomePage() {
        List<ShipsAttackerViewModel> shipsAttacker = new ArrayList<>();
        List<ShipsDefenderViewModel> shipsDefender = new ArrayList<>();
        List<ShipsWithStatusViewModel> allShipsStatus = new ArrayList<>();

        List<Ship> allShips = shipRepository.findAllSorted();
        for (int i = 0; i < allShips.size(); i++) {
            Ship ship = allShips.get(i);
            String id = ship.getId();
            String name = ship.getName();
            Integer health = ship.getHealth();
            Integer power = ship.getPower();

            if (ship.getOwn().getUsername().equals(loggedUser.getUsername())) {
                shipsAttacker.add(new ShipsAttackerViewModel(id, name, health, power));
            } else {
                shipsDefender.add(new ShipsDefenderViewModel(id, name, health, power));
            }
            allShipsStatus.add(new ShipsWithStatusViewModel(id, name, health, power));
        }

        return new ShipsHomePage(shipsAttacker, shipsDefender, allShipsStatus);
    }

    @Override
    public void battle(BattleShipsBindingModel battleShipsBindingModel) {
        Ship attackerShip = this.shipRepository.findShipById(battleShipsBindingModel.getAttackShipId());
        Ship defenderShip = this.shipRepository.findShipById(battleShipsBindingModel.getDefenderShipId());
        int healthDefShip = defenderShip.getHealth() - attackerShip.getPower();
        if (healthDefShip <= 0) {
            this.shipRepository.delete(defenderShip);
        } else {
            defenderShip.setHealth(healthDefShip);
            this.shipRepository.save(defenderShip);
        }
    }
}

