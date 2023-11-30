package rpg;

public class Hero {

    private String name;
    private int experience;
    private Weapon axe;

    public Hero(String name, Weapon axe/*Dependency Injection*/) {
        this.name = name;
        this.experience = 0;
        this.axe = axe;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.axe;
    }

    public void attack(Target dummy) {
        this.axe.attack(dummy);

        if (dummy.isDead()) {
            this.experience += dummy.giveExperience();
        }
    }
}
