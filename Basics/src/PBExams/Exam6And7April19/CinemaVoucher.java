package PBExams.Exam6And7April19;

import java.util.Scanner;

public class CinemaVoucher {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int money = Integer.parseInt(scanner.nextLine());
        int countTickets = 0;
        int countProducts = 0;

        String purchase = scanner.nextLine();
        while (!"End".equals(purchase)) {

            if (purchase.length() > 8) {

                char symbol1 = purchase.charAt(0);
                char symbol2 = purchase.charAt(1);
                int priceTicket = symbol1 + symbol2;

                if (money < priceTicket) {
                    break;
                } else {
                    money -= priceTicket;
                }
                countTickets++;
            } else {

                int priceProduct = purchase.charAt(0);

                if (money < priceProduct) {
                    break;
                } else {
                    money -= priceProduct;
                }
                countProducts++;
            }
            purchase = scanner.nextLine();
        }
        System.out.println(countTickets);
        System.out.print(countProducts);
    }
}
