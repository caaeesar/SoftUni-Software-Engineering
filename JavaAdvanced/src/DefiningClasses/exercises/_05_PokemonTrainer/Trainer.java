package DefiningClasses.exercises._05_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges = 0;
    private List<Pokemon> pokemonList;

    public Trainer(String name) {
        this.name = name;
        pokemonList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getBadges() {
        return this.badges;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public boolean isHavePokemonElement(String searchElement) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getElement().equals(searchElement)) {
                return true;
            }
        }
        return false;
    }

    public void receiveBadge() {
        this.badges += 1;
    }

    public void decreasingPokemonHealth() {
        pokemonList.removeIf(Pokemon::isDead);
        for (Pokemon pokemon : pokemonList) {
            if (!pokemon.isDead()) {
                pokemon.loseHealth();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemonList.size());
    }
}
