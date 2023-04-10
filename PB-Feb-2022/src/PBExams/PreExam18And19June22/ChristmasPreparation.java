package PBExams.PreExam18And19June22;

import java.util.Scanner;

public class ChristmasPreparation {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int paper = Integer.parseInt(scanner.nextLine());
        int cloth = Integer.parseInt(scanner.nextLine());
        double litresGlu = Double.parseDouble(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());

        double pricePaper = paper * 5.80;
        double priceCloth = cloth * 7.20;
        double priceGlu = litresGlu * 1.20;

        double totalSum = pricePaper + priceCloth + priceGlu;
        double result = totalSum - (totalSum * (percent * 1.00 / 100));

        System.out.printf("%.3f", result);
    }
}
