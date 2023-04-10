package PBExams.Exam28And29March20;

import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double capacity = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();
        int count = 0;
        int loadedLuggage = 0;

        while (!"End".equals(command)) {

            double currentSuitcase = Double.parseDouble(command);;
            count++;

            if (count == 3) {
                capacity -= (currentSuitcase + (currentSuitcase * 0.1));
                count = 0;
            } else {
                capacity -= currentSuitcase;
            }
            if (capacity <= 0) {
                System.out.println("No more space!");
                break;
            }
            loadedLuggage++;
            command = scanner.nextLine();
        }

        if ("End".equals(command)) {
            System.out.println("Congratulations! All suitcases are loaded!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", loadedLuggage);
    }
}
