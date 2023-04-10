package PBExams.Exam20And21April19;

import java.util.Scanner;

public class EasterTrip {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();
        String date = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double priceForNight = 0.00;

        switch (date) {

            case "21-23":

                switch (destination) {

                    case "France":
                        priceForNight = 30;
                        break;
                    case "Italy":
                        priceForNight = 28;
                        break;
                    case "Germany":
                        priceForNight = 32;
                        break;
                }
                break;
            case "24-27":

                switch (destination) {

                    case "France":
                        priceForNight = 35;
                        break;
                    case "Italy":
                        priceForNight = 32;
                        break;
                    case "Germany":
                        priceForNight = 37;
                        break;
                }
                break;
            case "28-31":

                switch (destination) {

                    case "France":
                        priceForNight = 40;
                        break;
                    case "Italy":
                        priceForNight = 39;
                        break;
                    case "Germany":
                        priceForNight = 43;
                        break;
                }
                break;
        }
        System.out.printf("Easter trip to %s : %.2f leva.", destination, (priceForNight * nights));
    }
}
