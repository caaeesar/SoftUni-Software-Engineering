package PBExams.Exam15And16June19;

import java.util.Scanner;

public class MovieDestination {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        double price = 0.00;

        switch (destination) {

            case "Dubai":

                switch (season) {

                    case "Winter":
                        price = 45000;
                        break;
                    case "Summer":
                        price = 40000;
                        break;
                }
                break;
            case "Sofia":

                switch (season) {

                    case "Winter":
                        price = 17000;
                        break;
                    case "Summer":
                        price = 12500;
                        break;
                }
                break;
            case "London":

                switch (season) {

                    case "Winter":
                        price = 24000;
                        break;
                    case "Summer":
                        price = 20250;
                        break;
                }
                break;
        }
        double totalSum = price * days;

        if ("Dubai".equals(destination)) {
            totalSum -= (totalSum * 0.30);
        } else if ("Sofia".equals(destination)) {
            totalSum += (totalSum * 0.25);
        }

        if (budget >= totalSum) {
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", budget - totalSum);
        } else {
            System.out.printf("The director needs %.2f leva more!", totalSum - budget);
        }
    }
}
