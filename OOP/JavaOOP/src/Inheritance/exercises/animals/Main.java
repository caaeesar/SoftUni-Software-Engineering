package Inheritance.exercises.animals;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final String BEAST = "Beast!";

    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!BEAST.equals(input)) {

            String typeOfAnimal = input;
            String[] animalData = Arrays.stream(scanner.nextLine().split("\\s+")).toArray(String[]::new);

            String name = animalData[0];
            int age = Integer.parseInt(animalData[1]);
            String gender = animalData[2];

            Animal animal = null;

            try {
                switch (typeOfAnimal) {
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age);
                        break;
                }

                System.out.println(animal);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
    }
}
