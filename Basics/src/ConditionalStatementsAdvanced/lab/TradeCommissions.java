package ConditionalStatementsAdvanced.lab;

import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        double sales = Double.parseDouble(scanner.nextLine());
        double commission = 0.00;
        boolean isValid = town.equals("Sofia") || town.equals("Varna") || town.equals("Plovdiv");

        if ((sales >= 0) && (sales <= 500)) {
            switch (town) {
                case "Sofia":
                    commission = sales * 0.05;
                    break;
                case "Varna":
                    commission = sales * 0.045;
                    break;
                case "Plovdiv":
                    commission = sales * 0.055;
                    break;
            }

        } else if ((sales > 500) && (sales <= 1000)) {
            switch (town) {
                case "Sofia":
                    commission = sales * 0.07;
                    break;
                case "Varna":
                    commission = sales * 0.075;
                    break;
                case "Plovdiv":
                    commission = sales * 0.08;
                    break;
            }
        } else if ((sales > 1000) && (sales <= 10000)) {
            switch (town) {
                case "Sofia":
                    commission = sales * 0.08;
                    break;
                case "Varna":
                    commission = sales * 0.1;
                    break;
                case "Plovdiv":
                    commission = sales * 0.12;
                    break;
            }
        } else if (sales > 10000) {
            switch (town) {
                case "Sofia":
                    commission = sales * 0.12;
                    break;
                case "Varna":
                    commission = sales * 0.13;
                    break;
                case "Plovdiv":
                    commission = sales * 0.145;
                    break;
            }
        }
        if (sales < 0 || !isValid) {
            System.out.println("error");
        } else {
            System.out.printf("%.2f", commission);
        }
    }
}
