package PBExams.Exam15And16June19;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int seats = 0;
        int totalIncomes = 0;

        while (!"Movie time!".equals(command)) {

            int currentVisitors = Integer.parseInt(command);
            seats += currentVisitors;

            if (seats > capacity) {
                System.out.println("The cinema is full.");
                break;
            }
            int currentPaid = 5 * currentVisitors;

            if (currentVisitors % 3 == 0) {
                currentPaid -= 5;
            }
            totalIncomes += currentPaid;
            command = scanner.nextLine();
        }
        if ("Movie time!".equals(command)) {
            System.out.printf("There are %d seats left in the cinema.%n", capacity - seats);
        }
        System.out.printf("Cinema income - %d lv.", totalIncomes);
    }
}
