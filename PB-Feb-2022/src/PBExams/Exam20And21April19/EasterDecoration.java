package PBExams.Exam20And21April19;

import java.util.Scanner;

public class EasterDecoration {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int allCustomers = Integer.parseInt(scanner.nextLine());
        double price = 0.00;
        double currentSum = 0.00;
        double totalSum = 0.00;
        int purchases = 0;
        int currentPurchases = 0;

        for (int customer = 1; customer <= allCustomers; customer++) {

            String command = scanner.nextLine();

            while (!command.equals("Finish")) { 

                String product = command;
                purchases++;
                currentPurchases++;

                switch (product) {

                    case "basket":
                        price = 1.50;
                        break;
                    case "wreath":
                        price = 3.80;
                        break;
                    case "chocolate bunny":
                        price = 7;
                        break;
                }
                currentSum += price;
                command = scanner.nextLine();
            }

            if (currentPurchases % 2 == 0) {
                double discount = currentSum * 0.2;
                currentSum -= discount;
            }
            System.out.printf("You purchased %d items for %.2f leva.%n", currentPurchases, currentSum);
            totalSum += currentSum;
            currentPurchases = 0;
            currentSum = 0.00;
        }
        double averageMoney = totalSum / allCustomers;
        System.out.printf("Average bill per client is: %.2f leva.", averageMoney);
    }
}
