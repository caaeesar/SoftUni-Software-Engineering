package ConditionalStatementsAdvanced.moreExercise;

import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String typeGroup = scanner.nextLine();
        int students = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());

        String sport = "";
        double price = 0.00;
        double discount = 0.00;

        switch (season) {
            case "Winter":

                switch (typeGroup) {
                    case "boys":
                        price = 9.60;
                        sport = "Judo";
                        break;
                    case "girls":
                        price = 9.60;
                        sport = "Gymnastics";
                        break;
                    case "mixed":
                        price = 10.00;
                        sport = "Ski";
                        break;
                }
                break;
            case "Spring":
                switch (typeGroup) {
                    case "boys":
                        price = 7.20;
                        sport = "Tennis";
                        break;
                    case "girls":
                        price = 7.20;
                        sport = "Athletics";
                        break;
                    case "mixed":
                        price = 9.50;
                        sport = "Cycling";
                        break;
                }
                break;
            case "Summer":
                switch (typeGroup) {
                    case "boys":
                        price = 15.00;
                        sport = "Football";
                        break;
                    case "girls":
                        price = 15.00;
                        sport = "Volleyball";
                        break;
                    case "mixed":
                        price = 20.00;
                        sport = "Swimming";
                        break;
                }
                break;
        }
        double totalPrice = nights * price * students;

        if (students >= 10 && students < 20) {
            discount = totalPrice * 0.05;
        } else if (students >= 20 && students < 50) {
            discount = totalPrice * 0.15;
        } else if (students >= 50) {
            discount = totalPrice * 0.5;
        }

        System.out.printf("%s %.2f lv.", sport, totalPrice - discount);
    }
}
