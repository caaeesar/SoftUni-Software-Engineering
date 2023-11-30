package Polymorphism.lab.WildFarm.animal;

import Polymorphism.lab.WildFarm.food.Food;
import Polymorphism.lab.WildFarm.food.Meat;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public boolean isGoingToEat(Food food) {
        return food instanceof Meat;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
