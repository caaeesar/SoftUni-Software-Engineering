package JavaBook;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String ticket = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());
        double vip = 499.99;
        double normal = 249.99;
        double transport = 0.00;
        double priceTicket = 0.00;

        if (people >= 1 && people <= 4) {
            transport = budget * 0.75;
        } else if (people >= 5 && people <= 9) {
            transport = budget * 0.6;
        } else if (people >= 10 && people <= 24) {
            transport = budget * 0.5;
        } else if (people >= 25 && people <= 49) {
            transport = budget * 0.4;
        } else if (people >= 50) {
            transport = budget * 0.25;
        }

        switch (ticket) {
            case "VIP":
                priceTicket = vip * people;
                break;
            case "Normal":
                priceTicket = normal * people;
                break;
        }
        double leftMoney = budget - transport;
        boolean isEnough = leftMoney >= priceTicket;
        if (isEnough) {
            double moneyLeft = leftMoney - priceTicket;
            System.out.printf("Yes! You have %.2f leva left.", moneyLeft);
        } else {
            double needMoney = priceTicket - leftMoney;
            System.out.printf("Not enough money! You need %.2f leva.", needMoney);
        }

    }
}
