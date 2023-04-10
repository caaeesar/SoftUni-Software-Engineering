package PBExams.Exam25And26Jun22;

import java.util.Scanner;

public class PastryShop {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String sweet = scanner.nextLine();
        int orderSweet = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());
        double price = 0.00;

        if (day <= 15) {

            switch (sweet) {

                case "Cake":
                    price = 24;
                    break;
                case "Souffle":
                    price = 6.66;
                    break;
                case "Baklava":
                    price = 12.60;
                    break;
            }

        } else  {
            switch (sweet) {

                case "Cake":
                    price = 28.70;
                    break;
                case "Souffle":
                    price = 9.80;
                    break;
                case "Baklava":
                    price = 16.98;
                    break;
            }
        }
        double sum = price * orderSweet;
        double discount = 0;

        if (day <= 22) {

            if (sum >= 100 && sum <= 200) {

                discount = sum * 0.15;
                sum -= discount;

            } else if (sum > 200) {
                discount = sum * 0.25;
                sum -= discount;
            }
            if (day <= 15) {
                discount = sum * 0.1;
                sum -= discount;
            }
        }
        System.out.printf("%.2f", sum);
    }
}
