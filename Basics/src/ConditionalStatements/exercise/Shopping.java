package ConditionalStatements.exercise;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int videoCards = Integer.parseInt(scanner.nextLine());
        int processors = Integer.parseInt(scanner.nextLine());
        int ramMemory = Integer.parseInt(scanner.nextLine());

        double priceVideoC = 250;
        double priceProcess = (videoCards * priceVideoC) * 0.35;
        double priceRamMem = (videoCards * priceVideoC) * 0.1;
        double totalSum = ((videoCards * priceVideoC) + (processors * priceProcess) + (ramMemory * priceRamMem));

        if(videoCards > processors) {
            totalSum -= totalSum * 0.15;
        }
        if (budget >= totalSum) {
            System.out.printf("You have %.2f leva left!", budget - totalSum);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", totalSum - budget);
        }
    }
}
