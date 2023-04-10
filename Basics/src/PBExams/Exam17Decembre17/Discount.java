package PBExams.Exam17Decembre17;

import java.util.Scanner;

public class Discount {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String modelCar = scanner.nextLine();
        long VIN = Long.parseLong(scanner.nextLine());
        String means = scanner.nextLine();
        double price = Double.parseDouble(scanner.nextLine());

        boolean condition1 = means.equalsIgnoreCase("good");
        boolean condition2 = VIN < 90_000 && VIN % 2 == 0;
        double profit = price * 0.15;
        boolean condition3 = profit > 400;

        if (condition1 && condition2 && condition3) {
            System.out.printf("yes - %s%n", modelCar);
            System.out.printf("profit - %.2f%n", profit);
        } else {
            System.out.println("no");
            if (!condition1) {
                System.out.println("The car is in bad condition");
            }
            if (!condition2) {
                System.out.printf("VIN %d is not valid%n", VIN);
            }
            if (!condition3) {
                System.out.printf("Cannot make discount, profit too low - %.2f%n", profit);
            }
        }
    }
}
