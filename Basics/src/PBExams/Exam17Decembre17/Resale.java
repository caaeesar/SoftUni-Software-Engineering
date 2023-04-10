package PBExams.Exam17Decembre17;

import java.util.Scanner;

public class Resale {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String modelCar = scanner.nextLine();
        double price = Double.parseDouble(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        double taxes = (price * 0.2) + 275;
        int sumForDays = days * 20;

        double totalSum = price + taxes + sumForDays;
        double profit = totalSum * 0.15;

        System.out.printf("The %s with initial price of %.2f BGN will sell for %.2f BGN%n",modelCar, price, totalSum);
        System.out.printf("Profit: %.2f BGN",profit);
    }
}
