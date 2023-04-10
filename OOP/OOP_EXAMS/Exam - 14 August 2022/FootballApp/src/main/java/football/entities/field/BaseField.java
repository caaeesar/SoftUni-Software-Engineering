package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.*;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    protected BaseField(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new LinkedList<>();
        this.players = new LinkedList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int sumEnergy() {
        return this.supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this.capacity <= this.players.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        this.players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName())).append(System.lineSeparator());

        List<String> playersNames = this.players.stream().map(Player::getName).collect(Collectors.toList());
        String playersOrNone;
        if (this.players.isEmpty()) {
            playersOrNone = "none";
        } else {
            playersOrNone = String.join(" ", playersNames);
        }

        info.append(String.format("Player: %s",playersOrNone)).append(System.lineSeparator());
        info.append(String.format("Supplement: %d",this.supplements.size())).append(System.lineSeparator());
        info.append(String.format("Energy: %d",this.sumEnergy())).append(System.lineSeparator());
        return info.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return Collections.unmodifiableCollection(this.players); //todo
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(this.supplements);//todo
    }

    @Override
    public String getName() {
        return this.name;
    }
}
