package ConditionalStatementsAdvanced.moreExercise;

import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // един сезон е 4 месеца
        String season = scanner.nextLine();
        double kmPerMonth = Double.parseDouble(scanner.nextLine());
        double moneyPerKm = 0.00;

        if (kmPerMonth <= 5000) {

            switch (season) {
                case "Spring":
                case "Autumn":
                    moneyPerKm = 0.75;
                    break;
                case "Summer":
                    moneyPerKm = 0.90;
                    break;
                case "Winter":
                    moneyPerKm = 1.05;
                    break;
            }
        } else if (kmPerMonth > 5000 && kmPerMonth <= 10000) {

            switch (season) {
                case "Spring":
                case "Autumn":
                    moneyPerKm = 0.95;
                    break;
                case "Summer":
                    moneyPerKm = 1.10;
                    break;
                case "Winter":
                    moneyPerKm = 1.25;
                    break;
            }
        } else if (kmPerMonth > 10000 && kmPerMonth <= 20000) {
            moneyPerKm = 1.45;
        }
        double salary = (kmPerMonth * moneyPerKm) * 4;
        double tax = salary * 0.1;

        System.out.printf("%.2f",salary - tax);
    }
}
