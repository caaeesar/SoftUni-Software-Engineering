package PBExams.Exam28And29March20;

import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int totalFoodKg = Integer.parseInt(scanner.nextLine());
        int totalFoodGr = totalFoodKg * 1000;
        String command = scanner.nextLine();
        int allEatingFood = 0;

        while (!"Adopted".equals(command)) {

            int currentEatFood = Integer.parseInt(command);
            allEatingFood += currentEatFood;

            command = scanner.nextLine();
        }

        if (totalFoodGr >= allEatingFood) {
            System.out.printf("Food is enough! Leftovers: %d grams.", totalFoodGr - allEatingFood);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", allEatingFood - totalFoodGr);
        }
    }
}
