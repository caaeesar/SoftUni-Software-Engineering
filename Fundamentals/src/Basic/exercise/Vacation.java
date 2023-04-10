package Basic.exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String group = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0.00;

        switch (group) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16;
                        break;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }
                break;
        }
        double totalSum = people * price;

        if (group.equals("Students") && people >= 30) {
            totalSum -= (totalSum * 0.15);
        } else if (group.equals("Business") && people >= 100) {
            totalSum -= (10 * price);
        } else if (group.equals("Regular") && people >= 10 && people <= 20) {
            totalSum -= (totalSum * 0.05);
        }
        System.out.printf("Total price: %.2f", totalSum);
    }
}
