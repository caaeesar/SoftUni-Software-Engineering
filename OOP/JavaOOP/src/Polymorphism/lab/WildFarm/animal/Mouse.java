package Polymorphism.lab.WildFarm.animal;

import Polymorphism.lab.WildFarm.food.Food;
import Polymorphism.lab.WildFarm.food.Vegetable;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public boolean isGoingToEat(Food food) {
        return food instanceof Vegetable;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
