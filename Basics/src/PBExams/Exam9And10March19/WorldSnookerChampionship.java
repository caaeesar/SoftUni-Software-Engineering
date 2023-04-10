package PBExams.Exam9And10March19;

import java.util.Scanner;

public class WorldSnookerChampionship {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String championship = scanner.nextLine();
        String ticket = scanner.nextLine();
        int countTickets = Integer.parseInt(scanner.nextLine());
        String photo = scanner.nextLine();
        boolean isHaveFreePhoto = false;

        double price = 0.00;

        switch (championship) {

            case "Quarter final":

                switch (ticket) {

                    case "Standard":
                        price = 55.50;
                        break;
                    case "Premium":
                        price = 105.20;
                        break;
                    case "VIP":
                        price = 118.90;
                        break;
                }
                break;
            case "Semi final":

                switch (ticket) {

                    case "Standard":
                        price = 75.88;
                        break;
                    case "Premium":
                        price = 125.22;
                        break;
                    case "VIP":
                        price = 300.40;
                        break;
                }
                break;
            case "Final":

                switch (ticket) {

                    case "Standard":
                        price = 110.10;
                        break;
                    case "Premium":
                        price = 160.66;
                        break;
                    case "VIP":
                        price = 400;
                        break;
                }
                break;
        }

        double totalSum = countTickets * price;

        if (totalSum > 4000) {
            isHaveFreePhoto = true;
            double discount = totalSum * 0.25;
            totalSum -= discount;
        } else if (totalSum > 2500) {
            double discount = totalSum * 0.1;
            totalSum -= discount;
        }

        if ("Y".equals(photo)) {

            if (!isHaveFreePhoto) {
                totalSum += (countTickets * 40);
            }
        }
        System.out.printf("%.2f", totalSum);
    }
}
