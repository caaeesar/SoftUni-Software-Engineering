package Polymorphism.lab.WildFarm.animal;

import Polymorphism.lab.WildFarm.food.Food;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public abstract void makeSound();

    public abstract boolean isGoingToEat(Food food);

    protected String getAnimalName() {
        return animalName;
    }

    protected String getAnimalType() {
        return animalType;
    }

    protected final Double getAnimalWeight() {
        return animalWeight;
    }

    protected final Integer getFoodEaten() {
        return foodEaten;
    }


    public void eat(Food food) {
        if (isGoingToEat(food)) {
            this.foodEaten += food.getQuantity();
        } else {
            if (animalType.equals("Mouse")) {
                System.out.println("Mice are not eating that type of food!");
            } else {
                System.out.printf("%ss are not eating that type of food!\n", this.animalType);
            }
        }
    }
}
