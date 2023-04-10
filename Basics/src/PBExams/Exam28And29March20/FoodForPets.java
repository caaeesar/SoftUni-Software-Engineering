package PBExams.Exam28And29March20;

import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int totalDays = Integer.parseInt(scanner.nextLine());
        double totalFood = Double.parseDouble(scanner.nextLine());
        double totalDogEat = 0.00;
        double totalCatEat = 0.00;
        double bothEat = 0.00;
        int countDays = 0;
        double biscuits = 0.00;

        for (int currentDay = 1; currentDay <= totalDays; currentDay++) {

            int dogEating = Integer.parseInt(scanner.nextLine());
            int catEating = Integer.parseInt(scanner.nextLine());
            countDays++;

            bothEat += (dogEating + catEating);
            totalCatEat += catEating;
            totalDogEat += dogEating;

            if (countDays == 3) {

                biscuits += ((dogEating + catEating) * 0.1);
                countDays = 0;
            }
        }
        double percentEatFood = (bothEat / totalFood) * 100;
        double percentEatDog = (totalDogEat / bothEat) * 100;
        double percentEatCat = (totalCatEat / bothEat) * 100;

        double gr = Math.round(biscuits);
        System.out.printf("Total eaten biscuits: %.0fgr.%n", gr);
        System.out.printf("%.2f%% of the food has been eaten.%n", percentEatFood);
        System.out.printf("%.2f%% eaten from the dog.%n", percentEatDog);
        System.out.printf("%.2f%% eaten from the cat.", percentEatCat);
    }
}
