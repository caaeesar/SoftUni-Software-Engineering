package Exams.MidRetake.Exam_03;

import java.util.Scanner;

public class BlackFlag {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int totalDays = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        int expectedPlunder = Integer.parseInt(scanner.nextLine());

        double totalGain = 0.00;
        int countThirdDays = 0;
        int countFifthDays = 0;

        for (int currentDay = 1; currentDay <= totalDays; currentDay++) {

            countThirdDays++;
            countFifthDays++;
            totalGain += dailyPlunder;

            if (countThirdDays == 3) {
                double additionalPlunger = dailyPlunder * 0.5;
                totalGain += additionalPlunger;
                countThirdDays = 0;
            }

            if (countFifthDays == 5) {
                double lostGain = totalGain * 0.3;
                totalGain -= lostGain;
                countFifthDays = 0;
            }
        }
        if (totalGain >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.",totalGain);
        } else {
            double percentageLeft = (totalGain / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.",percentageLeft);
        }
    }
}
