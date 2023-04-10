package Methods.lab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double price = 0.00;

        switch (product) {
            case "coffee":
                price = 1.50;
                break;
            case "water":
                price = 1.00;
                break;
            case "coke":
                price = 1.40;
                break;
            case "snacks":
                price = 2.00;
                break;
        }
        printTotalPrice(quantity,price);
    }

    static void printTotalPrice(int quantity, double price) {
        System.out.printf("%.2f", quantity * price);
    }
}
