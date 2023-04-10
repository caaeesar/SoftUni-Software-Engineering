package ConditionalStatements.moreExercise;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int dayAway = Integer.parseInt(scan.nextLine());
        int leftFood = Integer.parseInt(scan.nextLine());
        double dogFood = Double.parseDouble(scan.nextLine());
        double catFood = Double.parseDouble(scan.nextLine());
        double turtleFood = Double.parseDouble(scan.nextLine()); // 1кг. = 1000г.

        double eatDog = dayAway * dogFood; // храната, която кучето ще изяде за тези дни
        double eatCat = dayAway * catFood;
        double eatTurtle = (dayAway * turtleFood) / 1000;
        double totalFood = eatCat + eatDog + eatTurtle;

        boolean isEnough = totalFood <= leftFood;

        if (isEnough) {
            double leftOver = Math.floor(leftFood - totalFood);
            System.out.printf("%.0f kilos of food left.",leftOver);
        } else {
            double needMore = Math.ceil(totalFood - leftFood);
            System.out.printf("%.0f more kilos of food are needed.", needMore);
        }
    }
}
