package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
                throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        this.fields.add(field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;
        switch (type) {
            case "Powdered":
                supplement = new Powdered();
                break;
            case "Liquid":
                supplement = new Liquid();
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        this.supplement.add(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement = this.supplement.findByType(supplementType);
        if (supplement == null) {
            String msg = String.format(NO_SUPPLEMENT_FOUND, supplementType);
            throw new IllegalArgumentException(msg);
        }
        this.supplement.remove(supplement);
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
        field.addSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerGender, String playerName, String nationality, int strength) {
        Player player;
        switch (playerGender) {
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
        String terrain = field.getClass().getSimpleName();

        boolean isSuitable = (terrain.equals("ArtificialTurf") && player.getClass().getSimpleName().equals("Women"))
                || (terrain.equals("NaturalGrass") && player.getClass().getSimpleName().equals("Men"));

        if (isSuitable) {
            field.addPlayer(player);
            return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerGender, fieldName);
        } else {
            return FIELD_NOT_SUITABLE;
        }
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
        field.drag();
        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        for (Field field : this.fields) {
            statistics.append(field.getInfo()).append(System.lineSeparator());
        }
        return statistics.toString().trim();
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = this.fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
        Collection<Player> players = field.getPlayers();
        int totalStrength = 0;
        for (Player player : players) {
            totalStrength += player.getStrength();
        }
        return String.format(STRENGTH_FIELD, fieldName, totalStrength);
    }

}
