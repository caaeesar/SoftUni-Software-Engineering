package Basic.exercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double sum = 0.00;

        while (!"Start".equals(command)) {

            double currentCoin = Double.parseDouble(command);
            if (currentCoin == 0.1
                    || currentCoin == 0.2
                    || currentCoin == 0.5
                    || currentCoin == 1.00
                    || currentCoin == 2.00) {
                sum += currentCoin;
            } else {
                System.out.printf("Cannot accept %.2f%n", currentCoin);
            }
            command = scanner.nextLine();
        }
        String input = scanner.nextLine();
        double price = 0.00;

        while (!"End".equals(input)) {

            String product = input;

            switch (product) {
                case "Nuts":
                    price = 2.00;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.00;
                    break;
                default:
                    System.out.println("Invalid product");
                    input = scanner.nextLine();
                    continue;
            }

            if (price <= sum) {
                sum -= price;
                System.out.printf("Purchased %s%n", product);
            } else {
                System.out.println("Sorry, not enough money");
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sum);
    }
}
