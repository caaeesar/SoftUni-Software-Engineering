package PBExams.Exam6And7July19;

import java.util.Scanner;

public class FamilyTrip {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double priceNight = Double.parseDouble(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());

        if (nights > 7) {
            priceNight -= priceNight * 0.05;
        }

        double totalPriceForNights = priceNight * nights;
        double addCost = budget * (percent / 100.00);

        double totalSum = totalPriceForNights + addCost;

        if (budget >= totalSum) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", budget - totalSum);
        } else {
            System.out.printf("%.2f leva needed.", totalSum - budget);
        }
    }
}
