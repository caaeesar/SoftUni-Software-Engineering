package Basic.moreExercise;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double balance = Double.parseDouble(scanner.nextLine());
        double budget = balance;
        String command = scanner.nextLine();
        double price = 0.00;
        double totalSpent = 0.00;

        while (!"Game Time".equals(command)) {

            String currentGame = command;
            switch (currentGame) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                default:
                    System.out.println("Not Found");
                    command = scanner.nextLine();
                    continue;
            }
            if (price > balance) {
                System.out.println("Too Expensive");
            } else {
                System.out.printf("Bought %s%n", currentGame);
                balance -= price;
                totalSpent += price;
            }
            if (balance == 0) {
                System.out.println("Out of money!");
                return;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, budget - totalSpent);
    }
}
