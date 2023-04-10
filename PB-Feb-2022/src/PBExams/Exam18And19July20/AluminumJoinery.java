package PBExams.Exam18And19July20;

import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int joinery = Integer.parseInt(scanner.nextLine());
        String kindJoinery = scanner.nextLine();
        String receiving = scanner.nextLine();

        double price = 0.00;

        if (joinery < 10) {
            System.out.println("Invalid order");
            return;
        }

        switch (kindJoinery) {

            case "90X130":
                price = 110 * joinery;

                if (joinery > 30 && joinery < 60) {
                    price -= (price * 0.05);
                } else if (joinery > 60) {
                    price -= (price * 0.08);
                }
                break;
            case "100X150":
                price = 140 * joinery;

                if (joinery > 40 && joinery < 80) {
                    price -= (price * 0.06);
                } else if (joinery > 80) {
                    price -= (price * 0.10);
                }
                break;
            case "130X180":
                price = 190 * joinery;

                if (joinery > 20 && joinery < 50) {
                    price -= (price * 0.07);
                } else if (joinery > 50) {
                    price -= (price * 0.12);
                }
                break;
            case "200X300":
                price = 250 * joinery;

                if (joinery > 25 && joinery < 50) {
                    price -= (price * 0.09);
                } else if (joinery > 50) {
                    price -= (price * 0.14);
                }
                break;
        }

        switch (receiving) {

            case "With delivery":
                price += 60;
                break;
        }

        if (joinery > 99) {
            price -= (price * 0.04);
        }

        System.out.printf("%.2f BGN", price);
    }
}
