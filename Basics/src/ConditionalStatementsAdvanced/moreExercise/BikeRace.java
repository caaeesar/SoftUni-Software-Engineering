package ConditionalStatementsAdvanced.moreExercise;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int juniorCyclist = Integer.parseInt(scanner.nextLine());
        int seniorCyclist = Integer.parseInt(scanner.nextLine());
        String tracks = scanner.nextLine();

        double juniorTax = 0.00;
        double seniorTax = 0.00;
        double donation = 0.00;
        double totalSum = 0.00;

        switch (tracks) {
            case "trail":
                juniorTax = 5.50;
                seniorTax = 7.00;
                break;
            case "cross-country":
                juniorTax = 8.00;
                seniorTax = 9.50;
                break;
            case "downhill":
                juniorTax = 12.25;
                seniorTax = 13.75;
                break;
            case "road":
                juniorTax = 20.00;
                seniorTax = 21.50;
                break;
        }

        totalSum = (juniorCyclist * juniorTax) + (seniorCyclist * seniorTax);
        int allCyclists = juniorCyclist + seniorCyclist;

        switch (tracks) {
            case "cross-country":
                if (allCyclists >= 50) {
                    totalSum -= totalSum * 0.25;
                }
                break;
        }
        double expenses = totalSum * 0.05;
        donation = totalSum - expenses;

        System.out.printf("%.2f",donation);
    }
}
