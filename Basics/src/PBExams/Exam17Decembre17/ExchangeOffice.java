package PBExams.Exam17Decembre17;

import java.util.Scanner;

public class ExchangeOffice {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String currency = scanner.nextLine();
        double euro = Double.parseDouble(scanner.nextLine());
        double currentValue = 0.00;

        if (euro > 1000) {
            euro += euro * 0.1;
        }

        switch (currency) {

            case "ETH":
                currentValue = euro / 250;
                if (currentValue < 80) {
                    System.out.println("Insufficient funds");
                    return;
                }
                break;
            case "BTC":
                currentValue = euro / 6400;

                if (currentValue >= 0.001) {
                    if (currentValue > 10) {
                        currentValue += currentValue * 0.1;
                    }
                } else {
                    System.out.println("Insufficient funds");
                    return;
                }
                break;
            case "XRP":
                currentValue = euro / 0.22;

                if (currentValue >= 80) {
                    if (currentValue > 1000 && currentValue < 2500) {
                        currentValue += currentValue * 0.5;
                    } else if (currentValue >= 2500){
                        currentValue += currentValue * 0.02;
                    }
                } else {
                    System.out.println("Insufficient funds");
                    return;
                }
                break;
            default:
                System.out.printf("EUR to %s is not supported.", currency);
                return;
        }
            System.out.printf("Successfully purchased %.3f %s", currentValue, currency);

    }
}
