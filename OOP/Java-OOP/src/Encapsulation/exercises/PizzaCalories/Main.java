package Encapsulation.exercises.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static final String END = "END";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Pizza pizza;
        try {
            pizza = createPizza(scanner.nextLine());
            Dough dough = createDough(scanner.nextLine());
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            return;
        }

        String input = scanner.nextLine();
        while (!END.equals(input)) {

            String[] data = input.split("\\s+");

            try {

                Topping topping = createTopping(data);
                pizza.addTopping(topping);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            input = scanner.nextLine();
        }
        System.out.print(pizza);
    }

    private static Topping createTopping(String[] data) {
        String toppingType = data[1];
        double weightInGrams = Double.parseDouble(data[2]);
        return new Topping(toppingType, weightInGrams);
    }


    private static Dough createDough(String secondLine) {
        String[] data = secondLine.split("\\s+");
        String flourType = data[1];
        String bakingTechnique = data[2];
        double weight = Double.parseDouble(data[3]);
        return new Dough(flourType, bakingTechnique, weight);
    }

    private static Pizza createPizza(String firstLine) {
        String[] data = firstLine.split("\\s+");
        String name = data[1];
        int numberOfToppings = Integer.parseInt(data[2]);
        return new Pizza(name, numberOfToppings);
    }
}
