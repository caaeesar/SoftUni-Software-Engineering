package WhileLoop.lab;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double totalMoney = 0.00;
        String input = scanner.nextLine();

        while (!input.equals("NoMoreMoney")) {
         double currentSum = Double.parseDouble(input);  // експлицитно кастване от String към double

            if (currentSum <= 0) {
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f\n", currentSum);
            totalMoney += currentSum;
           input = scanner.nextLine();
        }
        System.out.printf("Total: %.2f", totalMoney);
    }
}
