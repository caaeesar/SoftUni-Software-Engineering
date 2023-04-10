package PBExams.Exam20And21April19;

import java.util.Scanner;

public class EasterBake {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int allEasterBread = Integer.parseInt(scanner.nextLine());
        int maxSugar = Integer.MIN_VALUE;
        int maxFlour = Integer.MIN_VALUE;

        double totalSugar = 0.00;
        double totalFlour = 0.00;

        for (int currentBread = 1; currentBread <= allEasterBread; currentBread++) {

            int currentSugar = Integer.parseInt(scanner.nextLine());
            int currentFlour = Integer.parseInt(scanner.nextLine());

            totalSugar += currentSugar;
            totalFlour += currentFlour;

            if (currentSugar > maxSugar) {
                maxSugar = currentSugar;
            }
            if (currentFlour > maxFlour) {
                maxFlour = currentFlour;
            }
        }
        double packetsSugar = Math.ceil(totalSugar / 950);
        double packetsFlour = Math.ceil(totalFlour / 750);

        System.out.printf("Sugar: %.0f%n", packetsSugar);
        System.out.printf("Flour: %.0f%n", packetsFlour);
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.", maxFlour, maxSugar);
    }
}
