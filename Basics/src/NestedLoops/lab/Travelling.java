package NestedLoops.lab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();
        double savedMoney = 0.00;

        while (!destination.equals("End")) { // всички дестинации, които иска да посети

            double budget = Double.parseDouble(scanner.nextLine()); // нужни пари

            while (budget > savedMoney) {
                double currentSum = Double.parseDouble(scanner.nextLine());
                savedMoney += currentSum;

                if (savedMoney >= budget) {
                    System.out.printf("Going to %s!\n", destination);
                    savedMoney = 0;
                    break;
                }
            }
            destination = scanner.nextLine();
        }
    }
}
