package PBExams.Exam17Decembre17;

import java.util.Scanner;

public class Exchange {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double dollars = Double.parseDouble(scanner.nextLine());
        double bitcoin = Double.parseDouble(scanner.nextLine());
        int satoshi = Integer.parseInt(scanner.nextLine());

        double bitPurchased = dollars / bitcoin;
        double tax = bitPurchased * (satoshi * 1024.00) / 100_000_000;
        double totalBuy = bitPurchased - tax;
        double commission = totalBuy * 0.1;
        totalBuy -= commission;
        double taxDollars = tax * bitcoin;

        System.out.printf("Total bitcoin after expenses: %.5f BTC%n", totalBuy);
        System.out.printf("Tax payed: %.2f USD%n", taxDollars);
        System.out.printf("Programmer`s payment: %.5f BTC", commission);
    }
}
