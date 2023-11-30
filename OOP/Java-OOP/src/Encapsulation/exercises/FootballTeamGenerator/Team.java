package Encapsulation.exercises.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        ValidatorsUtil.validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
       this.players.add(player);
    }

    public void removePlayer(String playerName) {
        if (isExistPlayer(playerName)) {
            Player playerForRemove = getPlayer(playerName);
            this.players.remove(playerForRemove);
        } else {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
        }
    }

    private boolean isExistPlayer(String playerName) {
        return this.players.contains(getPlayer(playerName));
    }


    private Player getPlayer(String playerName) {
        for (Player player : this.players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public double getRating() {
        return Math.round(players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0));
    }

}
