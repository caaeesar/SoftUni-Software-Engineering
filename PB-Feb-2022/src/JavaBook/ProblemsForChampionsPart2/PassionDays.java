package JavaBook.ProblemsForChampionsPart2;

import java.util.Scanner;

public class PassionDays {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // todo  90/100 double => BigDecimal

        double budget = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();
        int countPurchases = 0;

        while (!command.equals("mall.Enter")) { // докато не влезне в мола не прави покупки;

            command = scanner.nextLine();
        }
        command = scanner.nextLine(); // четем първото действие;

        while (!command.equals("mall.Exit")) { // докато не излезне от мола => пазарува;


            for (int position = 0; position < command.length(); position++) {

                char symbol = command.charAt(position);

                if (budget < 0) {
                    continue;
                }

                if (symbol >= 'A' && symbol <= 'Z') {

                    double currentPrice = symbol * 0.5;

                    if (budget >= currentPrice) {

                        budget -= currentPrice;
                        countPurchases++;
                    }

                } else if (symbol >= 'a' && symbol <= 'z') {

                    double currentPrice = symbol * 0.3;

                    if (budget >= currentPrice) {

                        budget -= currentPrice;
                        countPurchases++;
                    }

                } else if (symbol == '%') {

                    if (budget > 0) {
                        budget /= 2.00;
                        countPurchases++;
                    }

                } else if (symbol == '*') {

                    budget += 10.00;

                } else {

                    if (budget >= symbol) {
                        budget -= symbol;
                        countPurchases++;
                    }
                }
            }
            command = scanner.nextLine();
        }
        if (countPurchases == 0) {
            System.out.printf("No purchases. Money left: %.2f lv.%n", budget);
        } else {
            System.out.printf("%d purchases. Money left: %.2f lv.%n", countPurchases, budget);
        }
    }
}






