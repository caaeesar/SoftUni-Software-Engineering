package WhileLoop.moreExercise;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // литри за: една бутилка препарат; нужни за измиването на 1 чиния и 1 тенджера;
        int millilitersPerBottle = 750;
        int millilitersPerPlate = 5;
        int millilitersPerCooker = 15;

        int countLoading = 0; // брояч за броя пъти зареждания
        int countPlate = 0; // брой на чиниите
        int countCooker = 0; // брой на тенджерите
        boolean isEnough = true;

        int bottles = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        double currentCleaner = bottles * millilitersPerBottle;

        while (!input.equals("End")) {
            int dishes = Integer.parseInt(input);
            countLoading += 1;

            if (countLoading == 3) { // на всяко 3-то зареждане имаме само тенджери
                currentCleaner -= (millilitersPerCooker * dishes);
                countLoading = 0; // зануляваме, за да почнем броенето на зарежданията отначало
                countCooker += dishes;
            } else {
                currentCleaner -= (millilitersPerPlate * dishes);
                countPlate += dishes;
            }
            if (currentCleaner < 0) {
                isEnough = false;
                break;
            }
            input = scanner.nextLine();
        }

        if (input.equals("End")) {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.\n", countPlate, countCooker);
            System.out.printf("Leftover detergent %.0f ml.", currentCleaner);
        }
        if (!isEnough) {
            System.out.printf("Not enough detergent, %.0f ml. more necessary!", Math.abs(currentCleaner));
        }
    }
}
