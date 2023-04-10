package ConditionalStatementsAdvanced.exercise;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] arguments) {
        Scanner scan = new Scanner(System.in);

        String month = scan.nextLine();
        int nights = Integer.parseInt(scan.nextLine());
        double priceStudio = 0.00;
        double priceApartment = 0.00;

        switch (month) {
            case "May":
            case "October":
                priceStudio = nights * 50;
                priceApartment = nights * 65;

                if (nights > 7 && nights <= 14) {
                    priceStudio -= priceStudio * 0.05;
                } else if (nights > 14) {
                    priceStudio -= priceStudio * 0.3;
                }
                break;

            case "June":
            case "September":
                priceStudio = nights * 75.20;
                priceApartment = nights * 68.70;

                if (nights > 14) {
                    priceStudio -= priceStudio * 0.2;
                }
                break;

            case "July":
            case "August":
                priceStudio = nights * 76;
                priceApartment = nights * 77;

                break;
        }

        if (nights > 14) {
            priceApartment -= priceApartment * 0.1;
        }

        System.out.printf("Apartment: %.2f lv.%n",priceApartment);
        System.out.printf("Studio: %.2f lv.",priceStudio);
    }
}
