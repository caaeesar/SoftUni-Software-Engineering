package JavaBook;

import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double priceVeg = Double.parseDouble(scan.nextLine()); // за кг
        double priceFru = Double.parseDouble(scan.nextLine()); // за кг
        int kgVegetables = Integer.parseInt(scan.nextLine());
        int kgFruits = Integer.parseInt(scan.nextLine());
        double eur = 1.94;

        double totalMoney = (priceFru * kgFruits) + (priceVeg * kgVegetables);
        System.out.printf("%f",totalMoney / eur);

    }
}
