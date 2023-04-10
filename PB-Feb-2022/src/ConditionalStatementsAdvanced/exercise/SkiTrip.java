package ConditionalStatementsAdvanced.exercise;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String room = scanner.nextLine();
        String assessment = scanner.nextLine();

        int nights = days - 1;
        double priceOneRoom = nights * 18.00;
        double priceApartment = nights * 25.00;
        double pricePresidentA = nights * 35.00;
        double totalPrice = 0.00;
        double discount = 0.00;


        if (days < 10) {

            switch (room) {
                case "room for one person":
                    discount = 0.00;
                    totalPrice = priceOneRoom - discount;
                    break;
                case "apartment":
                    discount = priceApartment * 0.3;
                    totalPrice = priceApartment - discount;
                    break;
                case "president apartment":
                    discount = pricePresidentA * 0.1;
                    totalPrice = pricePresidentA - discount;
                    break;

            }
        } else if (days > 10 && days <= 15) {

            switch (room) {
                case "room for one person":
                    discount = 0.00;
                    totalPrice = priceOneRoom - discount;
                    break;
                case "apartment":
                    discount = priceApartment * 0.35;
                    totalPrice = priceApartment - discount;
                    break;
                case "president apartment":
                    discount = pricePresidentA * 0.15;
                    totalPrice = pricePresidentA - discount;
                    break;
            }
        } else {

            switch (room) {
                case "room for one person":
                    discount = 0.00;
                    totalPrice = priceOneRoom - discount;
                    break;
                case "apartment":
                    discount = priceApartment * 0.5;
                    totalPrice = priceApartment - discount;
                    break;
                case "president apartment":
                    discount = pricePresidentA * 0.2;
                    totalPrice = pricePresidentA - discount;
                    break;
            }
        }

        switch (assessment) {
            case "positive":
                totalPrice += totalPrice * 0.25;
                break;
            case "negative":
                totalPrice -= totalPrice * 0.1;
                break;
        }
        System.out.printf("%.2f", totalPrice);
    }
}
