package PBExams.PreExam18And19June22;

import java.util.Scanner;

public class DeerOfSanta {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int totalFoodKg = Integer.parseInt(scanner.nextLine());
        double firstDeer = Double.parseDouble(scanner.nextLine());
        double secondDeer = Double.parseDouble(scanner.nextLine());
        double thirdDeer = Double.parseDouble(scanner.nextLine());

        double firstEating = days * firstDeer;
        double secondEating = days * secondDeer;
        double thirdEating = days * thirdDeer;

        double totalEating = firstEating + secondEating + thirdEating;

        if (totalEating <= totalFoodKg) {

            System.out.printf("%.0f kilos of food left.", Math.floor(totalFoodKg - totalEating));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(totalEating - totalFoodKg));
        }
    }
}
