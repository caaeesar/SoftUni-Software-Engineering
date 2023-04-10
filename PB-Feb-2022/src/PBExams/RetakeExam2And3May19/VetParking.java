package PBExams.RetakeExam2And3May19;

import java.util.Scanner;

public class VetParking {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int hoursForDay = Integer.parseInt(scanner.nextLine());
        double tax = 0.00;
        double totalSum = 0.00;
        double sumForDay = 0.00;

        for (int currentDay = 1; currentDay <= days; currentDay++) {

            for (int currentHour = 1; currentHour <= hoursForDay; currentHour++) {

                if (currentDay % 2 == 0 && currentHour % 2 != 0) {
                    tax = 2.50;
                } else if (currentDay % 2 != 0 && currentHour % 2 == 0) {
                    tax = 1.25;
                } else {
                    tax = 1;
                }
                sumForDay += tax;
            }
            totalSum += sumForDay;
            System.out.printf("Day: %d - %.2f leva%n", currentDay, sumForDay);
            sumForDay = 0;
        }
        System.out.printf("Total: %.2f leva", totalSum);
    }
}
