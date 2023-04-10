package PBExams.RetakeExam2And3May19;

import java.util.Scanner;

public class MobileOperator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String term = scanner.nextLine();
        String type = scanner.nextLine();
        String internet = scanner.nextLine();
        int months = Integer.parseInt(scanner.nextLine());
        double price = 0.00;

        switch (term) {

            case "one":

                switch (type) {

                    case "Small":
                        price = 9.98;
                        break;
                    case "Middle":
                        price = 18.99;
                        break;
                    case "Large":
                        price = 25.98;
                        break;
                    case "ExtraLarge":
                        price = 35.99;
                        break;
                }
                break;
            case "two":

                switch (type) {

                    case "Small":
                        price = 8.58;
                        break;
                    case "Middle":
                        price = 17.09;
                        break;
                    case "Large":
                        price = 23.59;
                        break;
                    case "ExtraLarge":
                        price = 31.79;
                        break;
                }
                break;
        }

        switch (internet) {

            case "yes":

                if (price <= 10) {
                    price += 5.50;
                } else if (price <= 30) {
                    price += 4.35;
                } else {
                    price += 3.85;
                }
                break;
        }

        if ("two".equals(term)) {
            price -= price * (3.75 / 100);
        }

        System.out.printf("%.2f lv.", price * months);
    }
}


