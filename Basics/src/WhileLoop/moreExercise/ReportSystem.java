package WhileLoop.moreExercise;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

       /* int moneyForCharity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int count = 0;
        int paymentCash = 0;
        int paymentCard = 0;
        int raiseCard = 0;
        int raiseCash = 0;
        boolean isRaised = false;

        while (!input.equals("End")) {
            int currentPrice = Integer.parseInt(input);
            ++count;

            if (count % 2 == 0) { //  плащане с карта;
                if (currentPrice < 10) { // не може с карта
                    System.out.println("Error in transaction!");
                    input = scanner.nextLine();
                    continue;
                }
                ++paymentCard;
                raiseCard += currentPrice;
                System.out.println("Product sold!");
            } else { // плащане в брой;
                if (currentPrice > 100) { // не може в брой
                    System.out.println("Error in transaction!");
                    input = scanner.nextLine();
                    continue;
                }
                ++paymentCash;
                raiseCash += currentPrice;
                System.out.println("Product sold!");

            }
            if ((raiseCard + raiseCash) >= moneyForCharity) {
                isRaised = true;
                break;
            }
            input = scanner.nextLine();
        }

        if (input.equals("End")) {
            System.out.println("Failed to collect required money for charity.");
        }
        double averageCard = raiseCard * 1.00 / paymentCard;
        double averageCash = raiseCash * 1.00 / paymentCash;
        if (isRaised) {
            System.out.printf("Average CS: %.2f\n", averageCash);
            System.out.printf("Average CC: %.2f", averageCard);
        } */

        int moneyRaised = Integer.parseInt(scanner.nextLine());
        double moneyCash = 0;
        double moneyCard = 0;
        double count = 0;
        double countCash = 0;
        double countCard = 0;

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            int currentSum = Integer.parseInt(input);
            count += 1; // people

            if (count % 2 == 0) { // credit card

                if (currentSum < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");
                    moneyCard += currentSum;
                    countCard++;
                }
            } else { // pay cash

                if (currentSum > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    System.out.println("Product sold!");
                    moneyCash += currentSum;
                    countCash++;
                }
            }
            if ((moneyCard + moneyCash) >= moneyRaised) {
                System.out.printf("Average CS: %.2f\n", moneyCash / countCash );
                System.out.printf("Average CC: %.2f", moneyCard / countCard);
                break;
            }
            input = scanner.nextLine();
        }
        if (input.equals("End")) {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
