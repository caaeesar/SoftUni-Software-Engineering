package Basic.exercise;

import java.util.Scanner;

public class Orders {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int orders = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0.00;

        for (int currentOrder = 1; currentOrder <= orders; currentOrder++) {

            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());

            double currentPrice = (days * capsulesCount) * pricePerCapsule;
            System.out.printf("The price for the coffee is: $%.2f%n", currentPrice);
            totalPrice += currentPrice;
        }
        System.out.printf("Total: $%.2f", totalPrice);
    }
}
