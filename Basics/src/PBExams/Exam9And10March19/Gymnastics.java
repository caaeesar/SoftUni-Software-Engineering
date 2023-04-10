package PBExams.Exam9And10March19;

import java.util.Scanner;

public class Gymnastics {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();
        String trainingDevice = scanner.nextLine();

        double difficult = 0.00;
        double performance = 0.00;

        switch (country) {

            case "Russia":

                switch (trainingDevice) {

                    case "ribbon":
                        difficult = 9.100;
                        performance = 9.400;
                        break;
                    case "hoop":
                        difficult = 9.300;
                        performance = 9.800;
                        break;
                    case "rope":
                        difficult = 9.600;
                        performance = 9.000;
                        break;
                }
                break;
            case "Bulgaria":

                switch (trainingDevice) {

                    case "ribbon":
                        difficult = 9.600;
                        performance = 9.400;
                        break;
                    case "hoop":
                        difficult = 9.550;
                        performance = 9.750;
                        break;
                    case "rope":
                        difficult = 9.500;
                        performance = 9.400;
                        break;
                }
                break;
            case "Italy":

                switch (trainingDevice) {

                    case "ribbon":
                        difficult = 9.200;
                        performance = 9.500;
                        break;
                    case "hoop":
                        difficult = 9.450;
                        performance = 9.350;
                        break;
                    case "rope":
                        difficult = 9.700;
                        performance = 9.150;
                        break;
                }
                break;
        }
        double totalPoint = difficult + performance;
        double percent = ((20 - totalPoint) / 20) * 100;

        System.out.printf("The team of %s get %.3f on %s.%n", country, totalPoint, trainingDevice);
        System.out.printf("%.2f%%", percent);
    }
}
