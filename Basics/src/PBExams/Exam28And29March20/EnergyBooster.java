package PBExams.Exam28And29March20;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String packaging = scanner.nextLine();
        int countPackages = Integer.parseInt(scanner.nextLine());
        double price = 0.00;

        switch (packaging) {

            case "small":

                switch (fruit) {
                    case "Watermelon":
                        price = 56;
                        break;
                    case "Mango":
                        price = 36.66;
                        break;
                    case "Pineapple":
                        price = 42.10;
                        break;
                    case "Raspberry":
                        price = 20;
                        break;
                }
                break;
            case "big":

                switch (fruit) {
                    case "Watermelon":
                        price = 28.70;
                        break;
                    case "Mango":
                        price = 19.60;
                        break;
                    case "Pineapple":
                        price = 24.80;
                        break;
                    case "Raspberry":
                        price = 15.20;
                        break;
                }
                break;
        }

        if ("small".equals(packaging)) {
            price *= 2;
        } else {
            price *= 5;
        }
        double totalPrice = price * countPackages;

        if (totalPrice >= 400 && totalPrice <= 1000) {
            totalPrice -= (totalPrice * 0.15);
        } else if (totalPrice > 1000) {
            totalPrice = (totalPrice * 0.5);
        }
        System.out.printf("%.2f lv.", totalPrice);
    }
}
