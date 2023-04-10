package PBExams.RetakeExam2And3May19;

import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double priceStrawberry = Double.parseDouble(scanner.nextLine());
        double bananas = Double.parseDouble(scanner.nextLine());
        double oranges = Double.parseDouble(scanner.nextLine());
        double raspberries = Double.parseDouble(scanner.nextLine());
        double strawberries = Double.parseDouble(scanner.nextLine());

        double priceRaspberry = priceStrawberry / 2;
        double priceOrange = priceRaspberry - (priceRaspberry * 0.4);
        double priceBananas = priceRaspberry - (priceRaspberry * 0.8);

        double totalBill = (bananas * priceBananas)
                + (oranges * priceOrange)
                + (raspberries * priceRaspberry)
                + (strawberries * priceStrawberry);

        System.out.printf("%.2f", totalBill);
    }
}
