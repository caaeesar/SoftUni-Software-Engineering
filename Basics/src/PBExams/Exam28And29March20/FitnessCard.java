package PBExams.Exam28And29March20;

import java.util.Scanner;

public class FitnessCard {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double amount = Double.parseDouble(scanner.nextLine());
        char sex = scanner.nextLine().charAt(0);
        int age = Integer.parseInt(scanner.nextLine());
        String sport = scanner.nextLine();
        double price = 0.00;

        switch (sport) {

            case "Gym":

                switch (sex) {

                    case 'm':
                        price = 42;
                        break;
                    case 'f':
                        price = 35;
                        break;
                }

                break;
            case "Boxing":

                switch (sex) {

                    case 'm':
                        price = 41;
                        break;
                    case 'f':
                        price = 37;
                        break;
                }

                break;
            case "Yoga":

                switch (sex) {

                    case 'm':
                        price = 45;
                        break;
                    case 'f':
                        price = 42;
                        break;
                }

                break;
            case "Zumba":

                switch (sex) {

                    case 'm':
                        price = 34;
                        break;
                    case 'f':
                        price = 31;
                        break;
                }

                break;
            case "Dances":

                switch (sex) {

                    case 'm':
                        price = 51;
                        break;
                    case 'f':
                        price = 53;
                        break;
                }

                break;
            case "Pilates":

                switch (sex) {

                    case 'm':
                        price = 39;
                        break;
                    case 'f':
                        price = 37;
                        break;
                }

                break;
        }
        if (age <= 19) {
            price -= (price * 0.2);
        }

        if (amount >= price) {
            System.out.printf("You purchased a 1 month pass for %s.", sport);
        } else {
            System.out.printf("You don't have enough money! You need $%.2f more.", price - amount);
        }
    }
}
