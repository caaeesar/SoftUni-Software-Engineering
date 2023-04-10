package Exams.MidRetake.Exam_01;

import java.util.Scanner;

public class ComputerStore {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalPrice = 0.00; // without taxes

        while (!input.equals("regular") && !input.equals("special")) {

            double currentPrice = Double.parseDouble(input);
            if (currentPrice < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }
            totalPrice += currentPrice;
            input = scanner.nextLine();
        }
        if (totalPrice == 0.00) {
            System.out.println("Invalid order!");
        } else {
            String customer = input;
            double taxes = totalPrice * 0.2;
            double finalPrice = 0.00;
            switch (customer) {
                case "special":
                    double discount = (totalPrice + taxes) * 0.1;
                    finalPrice = (totalPrice + taxes) - discount;
                    break;
                default:
                    finalPrice = totalPrice + taxes;
                    break;
            }
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n", totalPrice);
            System.out.printf("Taxes: %.2f$\n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", finalPrice);
        }
    }
}
