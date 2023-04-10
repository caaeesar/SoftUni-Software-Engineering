package Polymorphism.lab.WildFarm;


import Polymorphism.lab.WildFarm.animal.*;
import Polymorphism.lab.WildFarm.food.Food;
import Polymorphism.lab.WildFarm.food.Meat;
import Polymorphism.lab.WildFarm.food.Vegetable;

import java.util.Scanner;

public class Main {

    public static final String STOP_COMMAND = "End";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!STOP_COMMAND.equals(command)) {

            String[] animalInfo = command.split("\\s+");
            Animal animal = createAnimal(animalInfo);

            String[] foodInfo = scanner.nextLine().split("\\s+");
            Food food = createFood(foodInfo);

            animal.makeSound();
            animal.eat(food);
            System.out.println(animal);

            command = scanner.nextLine();
        }

    }

    private static Food createFood(String[] foodInfo) {
        Food food = null;
        String foodType = foodInfo[0];
        Integer foodQuantity = Integer.parseInt(foodInfo[1]);
        switch (foodType) {
            case "Vegetable":
                food = new Vegetable(foodQuantity);
                break;
            case "Meat":
                food = new Meat(foodQuantity);
                break;
        }
        return food;
    }

    private static Animal createAnimal(String[] animalInfo) {
        Animal animal = null;
        String type = animalInfo[0];
        String name = animalInfo[1];
        Double weight = Double.parseDouble(animalInfo[2]);
        String livingRegion = animalInfo[3];
        switch (type) {
            case "Cat":
                String breed = animalInfo[4];
                animal = new Cat(name, type, weight, livingRegion, breed);
                break;
            case "Tiger":
                animal = new Tiger(name, type, weight, livingRegion);
                break;
            case "Mouse":
                animal = new Mouse(name, type, weight, livingRegion);
                break;
            case "Zebra":
                animal = new Zebra(name, type, weight, livingRegion);
                break;
        }
        return animal;
    }
}
