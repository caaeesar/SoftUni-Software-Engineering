package Polymorphism.lab.WildFarm.animal;

import Polymorphism.lab.WildFarm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }


    @Override
    public boolean isGoingToEat(Food food) {
        return true;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.#");
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getAnimalType(), this.getAnimalName(),
                this.breed, df.format(getAnimalWeight()),
                this.getLivingRegion(), this.getFoodEaten());
    }
}
