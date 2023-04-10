package PBExams.Exam6And7April19;

import java.util.Scanner;

public class OscarsWeekInCinema {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        String hall = scanner.nextLine();
        int tickets = Integer.parseInt(scanner.nextLine());

        double price = 0.00;

        if ("A Star Is Born".equals(movie)) {

            switch (hall) {
                case "normal":
                    price = 7.50;
                    break;
                case "luxury":
                    price = 10.50;
                    break;
                case "ultra luxury":
                    price = 13.50;
                    break;
            }
        } else if ("Bohemian Rhapsody".equals(movie)) {

            switch (hall) {
                case "normal":
                    price = 7.35;
                    break;
                case "luxury":
                    price = 9.45;
                    break;
                case "ultra luxury":
                    price = 12.75;
                    break;
            }
        } else if ("Green Book".equals(movie)) {

            switch (hall) {
                case "normal":
                    price = 8.15;
                    break;
                case "luxury":
                    price = 10.25;
                    break;
                case "ultra luxury":
                    price = 13.25;
                    break;
            }
        } else if ("The Favourite".equals(movie)) {

            switch (hall) {
                case "normal":
                    price = 8.75;
                    break;
                case "luxury":
                    price = 11.55;
                    break;
                case "ultra luxury":
                    price = 13.95;
                    break;
            }
        }
        double totalSum = price * tickets;
        System.out.printf("%s -> %.2f lv.", movie, totalSum);
    }
}
