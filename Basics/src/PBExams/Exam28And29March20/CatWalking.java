package PBExams.Exam28And29March20;

import java.util.Scanner;

public class CatWalking {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int timeWalk = Integer.parseInt(scanner.nextLine());
        int dailyWalks = Integer.parseInt(scanner.nextLine());
        int dailyCalories = Integer.parseInt(scanner.nextLine());

        int totalMinWalking = timeWalk * dailyWalks;
        int totalCalories = totalMinWalking * 5;

        double enoughBurnedCal = dailyCalories * 0.5;

        if (totalCalories >= enoughBurnedCal) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", totalCalories);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", totalCalories);
        }
    }
}
