package PBExams.Exam18And19July20;

import java.util.Scanner;

public class AddBags {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double price20kg = Double.parseDouble(scanner.nextLine());
        double luggageKg = Double.parseDouble(scanner.nextLine());
        int daysBeforeTravel = Integer.parseInt(scanner.nextLine());
        int countLuggage = Integer.parseInt(scanner.nextLine());

        double price = 0.00;

        if (luggageKg < 10) {

            price = price20kg * 0.20;

        } else if (luggageKg <= 20) {

            price = price20kg / 2;

        } else {
            price = price20kg;
        }

        if (daysBeforeTravel < 7) {

            price += (price * 0.4);

        } else if (daysBeforeTravel <= 30) {

            price += (price * 0.15);

        } else {

            price += (price * 0.1);

        }
        double totalSum = price * countLuggage;

        System.out.printf("The total price of bags is: %.2f lv.", totalSum);
    }
}
