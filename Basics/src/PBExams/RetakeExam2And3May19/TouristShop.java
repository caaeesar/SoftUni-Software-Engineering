package PBExams.RetakeExam2And3May19;

import java.util.Scanner;

public class TouristShop {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String currentProduct = scanner.nextLine();
        int countProducts = 0;
        double sum = 0.00;
        int allProducts = 0;
        boolean enoughMoney = true;
        double needMoney = 0.00;

        while (!currentProduct.equals("Stop")) {

            countProducts++;
            allProducts++;
            double currentPrice = Double.parseDouble(scanner.nextLine());

            if (countProducts == 3) {
                currentPrice *= 0.5;
                countProducts = 0;
            }
            if (currentPrice > budget) {
                needMoney = currentPrice - budget;
                enoughMoney = false;
                break;
            } else {
                budget -= currentPrice;
                sum += currentPrice;
            }
            currentProduct = scanner.nextLine();
        }

        if (currentProduct.equals("Stop")) {
            System.out.printf("You bought %d products for %.2f leva.", allProducts, sum);
        }
        if (!enoughMoney) {
            System.out.println("You don't have enough money!");
            System.out.printf("You need %.2f leva!", needMoney);
        }
    }
}
