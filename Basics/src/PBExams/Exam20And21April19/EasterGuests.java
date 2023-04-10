package PBExams.Exam20And21April19;

import java.util.Scanner;

public class EasterGuests {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int guests = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double easterBreads = Math.ceil(guests / 3.00);
        double eggs = guests * 2;

        double totalPriceBreads = easterBreads * 4;
        double totalPriceEggs = eggs * 0.45;

        double totalSum = totalPriceBreads + totalPriceEggs;

        if (budget >= totalSum) {
            System.out.printf("Lyubo bought %.0f Easter bread and %.0f eggs.%n", easterBreads, eggs);
            System.out.printf("He has %.2f lv. left.", budget - totalSum);
        } else {
            System.out.println("Lyubo doesn't have enough money.");
            System.out.printf("He needs %.2f lv. more.", totalSum - budget);
        }
    }
}
