package PBExams.Exam17Decembre17;

import java.util.Scanner;

public class AlternativeCoins {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double bitcoin = Double.parseDouble(scanner.nextLine());
        double bitPrice = Double.parseDouble(scanner.nextLine());
        double currentBitPrice = Double.parseDouble(scanner.nextLine());
        double etherium = Double.parseDouble(scanner.nextLine());
        double neo = Double.parseDouble(scanner.nextLine());

        double profitDiff = (bitcoin * currentBitPrice) - (bitcoin * bitPrice);
        double etheriumPrice = currentBitPrice * 0.075;
        double neoPrice = etheriumPrice * 0.4;

        double totalInvest = (etherium * etheriumPrice) + (neo * neoPrice);

        if (profitDiff >= totalInvest) {
            System.out.printf("Stefcho bought %.4f Ethereum at a price of %.4f%n", etherium, etheriumPrice);
            System.out.printf("Stefcho bought %.4f Neo at a price of %.4f%n", neo, neoPrice);
            System.out.printf("Stefcho has %.2f profits left to spend.", profitDiff - totalInvest);
        } else {
            System.out.println("Stefcho does not have enough money to make this investment.");
            System.out.printf("He needs %.2f more in profits.", totalInvest - profitDiff);
        }
    }
}
