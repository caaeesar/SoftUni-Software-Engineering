package PBExams.Exam15And16June19;

import java.util.Scanner;

public class Series {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int movies = Integer.parseInt(scanner.nextLine());
        double totalSum = 0.00;

        for (int currentMovie = 1; currentMovie <= movies; currentMovie++) {

            String movieName = scanner.nextLine();
            double moviePrice = Double.parseDouble(scanner.nextLine());

            switch (movieName) {

                case "Thrones":
                    moviePrice *= 0.5;
                    break;
                case "Lucifer":
                    moviePrice -= (moviePrice * 0.4);
                    break;
                case "Protector":
                    moviePrice -= (moviePrice * 0.3);
                    break;
                case "TotalDrama":
                    moviePrice -= (moviePrice * 0.2);
                    break;
                case "Area":
                    moviePrice -= (moviePrice * 0.1);
                    break;
            }
            totalSum += moviePrice;
        }
        if (budget >= totalSum) {
            System.out.printf("You bought all the series and left with %.2f lv.", budget - totalSum);
        } else {
            System.out.printf("You need %.2f lv. more to buy the series!", totalSum - budget);
        }
    }
}
