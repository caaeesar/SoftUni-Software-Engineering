package PBExams.Exam6And7July19;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String drink = scanner.nextLine();
        String sugar = scanner.nextLine();
        int countDrink = Integer.parseInt(scanner.nextLine());

        double price = 0.00;

        switch (drink) {

            case "Espresso":

                switch (sugar) {

                    case "Without":
                        price = 0.90;
                        break;
                    case "Normal":
                        price = 1.00;
                        break;
                    case "Extra":
                        price = 1.20;
                        break;
                }

                break;

            case "Cappuccino":

                switch (sugar) {

                    case "Without":
                        price = 1.00;
                        break;
                    case "Normal":
                        price = 1.20;
                        break;
                    case "Extra":
                        price = 1.60;
                        break;
                }

                break;
            case "Tea":

                switch (sugar) {

                    case "Without":
                        price = 0.50;
                        break;
                    case "Normal":
                        price = 0.60;
                        break;
                    case "Extra":
                        price = 0.70;
                        break;
                }

                break;
        }

        double totalPrice = price * countDrink;
        double discount = 0.00;

        if (sugar.equals("Without")) {
             discount = totalPrice * 0.35;
            totalPrice -= discount;
        }
        if (drink.equals("Espresso") && countDrink >= 5) {
             discount = totalPrice * 0.25;
            totalPrice -= discount;
        }
        if (totalPrice > 15) {
             discount = totalPrice * 0.2;
            totalPrice -= discount;
        }

        System.out.printf("You bought %d cups of %s for %.2f lv.", countDrink, drink, totalPrice);
    }
}
