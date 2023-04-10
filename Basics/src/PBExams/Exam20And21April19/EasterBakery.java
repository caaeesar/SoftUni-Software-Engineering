package PBExams.Exam20And21April19;

import java.util.Scanner;

public class EasterBakery {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double priceFlour = Double.parseDouble(scanner.nextLine());
        double kgFlour = Double.parseDouble(scanner.nextLine());
        double kgSugar = Double.parseDouble(scanner.nextLine());
        int eggshells = Integer.parseInt(scanner.nextLine());
        int packets = Integer.parseInt(scanner.nextLine());

        double priceSugar = priceFlour - (priceFlour * 0.25);
        double priceEggshell = priceFlour + (priceFlour * 0.1);
        double pricePacket = priceSugar - (priceSugar * 0.8);

        double totalSum = (priceFlour * kgFlour)
                + (priceSugar * kgSugar)
                + (priceEggshell * eggshells)
                + (pricePacket * packets);

        System.out.printf("%.2f", totalSum);
    }
}
