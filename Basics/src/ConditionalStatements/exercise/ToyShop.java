package ConditionalStatements.exercise;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double holidayPrice = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int bears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        int allToys = puzzles + dolls + bears + minions + trucks;
        double bill = ((puzzles * 2.60) + (dolls * 3) + (bears * 4.10) + (minions * 8.20) + (trucks * 2));
        boolean isDiscount = allToys >= 50;

        if (isDiscount) {
            bill -= (bill * 0.25); // discount
        }

        double rent = bill * 0.1;
        double afterRent = bill - rent;
        double leftMoney = afterRent - holidayPrice;
        double needMoney = holidayPrice - afterRent;
        boolean isGoing = afterRent >= holidayPrice;

        if (isGoing) {
            System.out.printf("Yes! %.2f lv left.", leftMoney);
        } else { //boolean notGoing = afterRent < holidayPrice;
            System.out.printf("Not enough money! %.2f lv needed.", needMoney);
        }
    }
}
