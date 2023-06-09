package DefiningClasses.exercises._05_PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return this.element;
    }

    public boolean isDead(){
        return this.health - 10 <= 0;
    }

    public void loseHealth() {
        this.health -= 10;
    }

}
