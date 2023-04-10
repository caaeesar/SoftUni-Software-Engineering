package PBExams.Exam25And26Jun22;

import java.util.Scanner;

public class GoldMine {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int locations = Integer.parseInt(scanner.nextLine());

        for (int currentLocation = 1; currentLocation <= locations; currentLocation++) {

            double expectedGold = Double.parseDouble(scanner.nextLine());
            int daysDigging = Integer.parseInt(scanner.nextLine());
            double allGold = 0.00;

            for (int currentDay = 1; currentDay <= daysDigging; currentDay++) {

                double currentGold = Double.parseDouble(scanner.nextLine());
                allGold = allGold + currentGold;
            }
            double averageGold = allGold / daysDigging;
            if (averageGold >= expectedGold) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", averageGold);

            } else if (averageGold < expectedGold){
                System.out.printf("You need %.2f gold.%n", expectedGold - averageGold);
            } else if (averageGold == 0) {
                return;
            }
        }
    }
}
