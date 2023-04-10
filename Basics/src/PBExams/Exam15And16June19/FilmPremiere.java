package PBExams.Exam15And16June19;

import java.util.Scanner;

public class FilmPremiere {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        String packageForMovie = scanner.nextLine();
        int tickets = Integer.parseInt(scanner.nextLine());
        double price = 0.00;

        switch (projection) {

            case "John Wick":

                switch (packageForMovie) {

                    case "Drink":
                        price = 12;
                        break;
                    case "Popcorn":
                        price = 15;
                        break;
                    case "Menu":
                        price = 19;
                        break;
                }

                break;
            case "Star Wars":

                switch (packageForMovie) {

                    case "Drink":
                        price = 18;
                        break;
                    case "Popcorn":
                        price = 25;
                        break;
                    case "Menu":
                        price = 30;
                        break;
                }

                break;
            case "Jumanji":

                switch (packageForMovie) {

                    case "Drink":
                        price = 9;
                        break;
                    case "Popcorn":
                        price = 11;
                        break;
                    case "Menu":
                        price = 14;
                        break;
                }

                break;
        }
        double totalPrice = price * tickets;

        if ("Star Wars".equals(projection) && tickets >= 4) {
            totalPrice -= (totalPrice * 0.3);
        } else if ("Jumanji".equals(projection) && tickets == 2) {
            totalPrice -= (totalPrice * 0.15);
        }

        System.out.printf("Your bill is %.2f leva.", totalPrice);
    }
}
