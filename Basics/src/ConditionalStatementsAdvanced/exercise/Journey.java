package ConditionalStatementsAdvanced.exercise;

import java.util.Scanner;

public class Journey {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine(); // summer / winter
        String typeofVacation = "";        // Camp / Hotel
        String destination = "";          // Bulgaria / Balkans / Europe
        double spendMoney = 0.00;

        if (budget <= 100) {
            destination = "Bulgaria";

            switch (season) {
                case "summer":
                    typeofVacation = "Camp";
                    spendMoney = budget * 0.3;
                    break;
                case "winter":
                    typeofVacation = "Hotel";
                    spendMoney = budget * 0.7;
                    break;
            }
        } else if (budget <= 1000) {
            destination = "Balkans";

            switch (season) {
                case "summer":
                    typeofVacation = "Camp";
                    spendMoney = budget * 0.4;
                    break;
                case "winter":
                    typeofVacation = "Hotel";
                    spendMoney = budget * 0.8;
                    break;
            }
        } else if (budget > 1000) {
            destination = "Europe";
            typeofVacation = "Hotel";
            spendMoney = budget * 0.9;
        }

        System.out.printf("Somewhere in %s%n",destination);
        System.out.printf("%s - %.2f",typeofVacation,spendMoney);

    }
}
