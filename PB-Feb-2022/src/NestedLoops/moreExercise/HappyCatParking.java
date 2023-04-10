package NestedLoops.moreExercise;

import java.util.Scanner;

public class HappyCatParking {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int lastDay = Integer.parseInt(scanner.nextLine());
        int lastHour = Integer.parseInt(scanner.nextLine());
        double totalBill = 0.00;
        double currentBill = 0.00;
        double bill;

        for (int day = 1; day <= lastDay; day++) {

            for (int hour = 1; hour <= lastHour; hour++) {

                if (day % 2 == 0 && hour % 2 != 0) {
                     bill = 2.50;
                    currentBill += bill;
                } else if (day % 2 != 0 && hour % 2 == 0) {
                     bill = 1.25;
                    currentBill += bill;
                } else {
                     bill = 1.00;
                    currentBill += bill;
                }
                totalBill += bill;
            }
            System.out.printf("Day: %d - %.2f leva\n", day, currentBill);
            currentBill = 0.00;
        }
        System.out.printf("Total: %.2f leva", totalBill);
    }
}
