package PBExams.Exam20And21April19;

import java.util.Scanner;

public class EasterParty {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int guests = Integer.parseInt(scanner.nextLine());
        double priceInvitation = Double.parseDouble(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        if (guests >= 10 && guests <= 15) {
            priceInvitation -= priceInvitation * 0.15;
        } else if (guests > 15 && guests <= 20) {
            priceInvitation -= priceInvitation * 0.2;
        } else if (guests > 20){
            priceInvitation -= priceInvitation * 0.25;
        }

        double priceCake = budget * 0.1;
        double totalSum = (priceInvitation * guests) + priceCake;

        if (budget >= totalSum) {
            System.out.printf("It is party time! %.2f leva left.", budget - totalSum);
        } else {
            System.out.printf("No party! %.2f leva needed.", totalSum - budget);
        }
    }
}
