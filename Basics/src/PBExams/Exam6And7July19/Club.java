package PBExams.Exam6And7July19;

import java.util.Scanner;

public class Club {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double targetSum = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();

        double allSum = 0.00;


        while (!input.equals("Party!")) {

            String cocktail = input;
            int countCocktail = Integer.parseInt(scanner.nextLine());
            int price = cocktail.length();
            double totalPrice = countCocktail * price;

            if (totalPrice % 2 != 0) {
                double discount = totalPrice * 0.25;
                totalPrice -= discount;
            }
            allSum += totalPrice;

            if (allSum >= targetSum) {
                System.out.println("Target acquired.");
                System.out.printf("Club income - %.2f leva.", allSum);
                break;
            }

            input = scanner.nextLine();
        }
        if (input.equals("Party!")) {
            System.out.printf("We need %.2f leva more.%n", targetSum - allSum);
            System.out.printf("Club income - %.2f leva.", allSum);
        }
    }
}
