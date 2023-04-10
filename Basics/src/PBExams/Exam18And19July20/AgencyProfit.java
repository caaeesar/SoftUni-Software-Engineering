package PBExams.Exam18And19July20;

import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String airline = scanner.nextLine();
        int ticketsFoAdult = Integer.parseInt(scanner.nextLine());
        int ticketsFoChildren = Integer.parseInt(scanner.nextLine());
        double priceForAdult = Double.parseDouble(scanner.nextLine());
        double serviceFee = Double.parseDouble(scanner.nextLine());

        double priceForChildren = priceForAdult - (priceForAdult * 0.70);
        double totalPriceForAdult = priceForAdult + serviceFee;
        double totalPriceForChildren = priceForChildren + serviceFee;
        double income = ((totalPriceForAdult * ticketsFoAdult) + (totalPriceForChildren * ticketsFoChildren)) * 0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", airline, income);
    }
}
