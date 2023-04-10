package ConditionalStatementsAdvanced.moreExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String location = "";  //"Alaska" и "Morocco"
        String place = "";    // "Hotel", "Hut" или "Camp"
        double price = 0.00;

        if (budget <= 1000) {
            place = "Camp";

            switch (season) {
                case "Summer":
                    location = "Alaska";
                    price = budget * 0.65;
                    break;
                case "Winter":
                    location = "Morocco";
                    price = budget * 0.45;
                    break;
            }
        } else if (budget > 1000 && budget <= 3000) {
            place = "Hut";

            switch (season) {
                case "Summer":
                    location = "Alaska";
                    price = budget * 0.80;
                    break;
                case "Winter":
                    location = "Morocco";
                    price = budget * 0.60;
                    break;
            }
        } else if (budget > 3000) {
            place = "Hotel";

            switch (season) {
                case "Summer":
                    location = "Alaska";
                    price = budget * 0.9;
                    break;
                case "Winter":
                    location = "Morocco";
                    price = budget * 0.9;
                    break;
            }
        }

        System.out.printf("%s - %s - %.2f", location, place, price);
    }
}
