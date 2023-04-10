package PBExams.Exam20And21April19;

import java.util.Scanner;

public class PaintingEggs {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();
        String color = scanner.nextLine();
        int batches = Integer.parseInt(scanner.nextLine());
        int price = 0;

        switch (size) {

            case "Large":

                switch (color) {

                    case "Red":
                        price = 16;
                        break;
                    case "Green":
                        price = 12;
                        break;
                    case "Yellow":
                        price = 9;
                        break;
                }
                break;
            case "Medium":

                switch (color) {

                    case "Red":
                        price = 13;
                        break;
                    case "Green":
                        price = 9;
                        break;
                    case "Yellow":
                        price = 7;
                        break;
                }
                break;
            case "Small":

                switch (color) {

                    case "Red":
                        price = 9;
                        break;
                    case "Green":
                        price = 8;
                        break;
                    case "Yellow":
                        price = 5;
                        break;
                }
                break;
        }
        double totalSum = price * batches;
        double expenses = totalSum * 0.35;

        System.out.printf("%.2f leva.", totalSum - expenses);
    }
}
