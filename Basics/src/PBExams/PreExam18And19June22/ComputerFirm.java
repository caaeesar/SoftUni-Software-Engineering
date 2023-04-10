package PBExams.PreExam18And19June22;

import java.util.Scanner;

public class ComputerFirm {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int computers = Integer.parseInt(scanner.nextLine());
        double allSale = 0.00;
        double totalRating = 0.00;

        for (int currentComputer = 1; currentComputer <= computers; currentComputer++) {

            int number = Integer.parseInt(scanner.nextLine());
            int rating = number % 10;
            totalRating += rating;
            int possibleSale = number / 10;
            double currentSale = 0.00;

            switch (rating) {

                case 2:
                    currentSale = 0;
                    break;
                case 3:
                    currentSale = possibleSale * 0.5;
                    break;
                case 4:
                    currentSale = possibleSale * 0.7;
                    break;
                case 5:
                    currentSale = possibleSale * 0.85;
                    break;
                case 6:
                    currentSale = possibleSale * 1.00;
                    break;
            }
            allSale += currentSale;
        }
        double average = totalRating / computers;

        System.out.printf("%.2f%n", allSale);
        System.out.printf("%.2f", average);
    }
}
