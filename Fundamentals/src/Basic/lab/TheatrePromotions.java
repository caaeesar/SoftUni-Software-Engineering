package Basic.lab;

import java.util.Locale;
import java.util.Scanner;

public class TheatrePromotions {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine().toLowerCase();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;

        if (age < 0) {
            System.out.print("Error!");
            return;
        }

        if (age <= 18) {
            switch (day) {
                case "weekday":
                    price = 12;
                    break;
                case "weekend":
                    price = 15;
                    break;
                case "holiday":
                    price = 5;
                    break;
            }
        } else if (age <= 64) {
            switch (day) {
                case "weekday":
                    price = 18;
                    break;
                case "weekend":
                    price = 20;
                    break;
                case "holiday":
                    price = 12;
                    break;
            }
        } else if (age <= 122) {
            switch (day) {
                case "weekday":
                    price = 12;
                    break;
                case "weekend":
                    price = 15;
                    break;
                case "holiday":
                    price = 10;
                    break;
            }
        } else {
            System.out.print("Error!");
            return;
        }
        System.out.printf("%d$", price);
    }
}
