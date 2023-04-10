package ConditionalStatements.exercise;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int extras = Integer.parseInt(scanner.nextLine());
        double clothPrice = Double.parseDouble(scanner.nextLine());

        double movieSet = budget * 0.1;
        boolean hasDiscount = extras > 150;

        if (hasDiscount) {
            double discount = clothPrice * 0.1;
            clothPrice -= discount;
        }

        double allCloths = clothPrice * extras;
        double totalCosts = movieSet + allCloths;
        boolean willFilmed = totalCosts > budget;

        if (willFilmed) {
            double needMoney = totalCosts - budget;
            System.out.printf("Not enough money!%nWingard needs %.2f leva more.", needMoney);
        } else {
            double leftMoney = budget - totalCosts;
            System.out.printf("Action!%nWingard starts filming with %.2f leva left.",leftMoney);
        }
    }
}
