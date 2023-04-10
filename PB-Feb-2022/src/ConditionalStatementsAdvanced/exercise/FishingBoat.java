package ConditionalStatementsAdvanced.exercise;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] argument) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishmen = Integer.parseInt(scanner.nextLine());

        double price = 0.00;

        switch (season) {
            case "Spring":
                price = 3000;
                break;
            case "Summer":
            case "Autumn":
                price = 4200;
                break;
            case "Winter":
                price = 2600;
                break;
        }

        if (fishmen <= 6) {
            price -= price * 0.1;
        } else if (fishmen > 7 && fishmen <= 11) {
            price -= price * 0.15;
        } else if (fishmen > 12) {
            price -= price * 0.25;
        }
        if (fishmen % 2 == 0 && !season.equals("Autumn")) {
            price -= price * 0.05;
        }

        if (budget >= price) {
            System.out.printf("Yes! You have %.2f leva left.", budget - price);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.",price - budget);
        }

    }
}
