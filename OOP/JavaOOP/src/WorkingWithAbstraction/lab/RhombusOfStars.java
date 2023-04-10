package WorkingWithAbstraction.lab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] arguments) {

        int size = Integer.parseInt(new Scanner(System.in).nextLine()); // 3

        printTop(size);
        printBottom(size);
    }

    private static void printTop(int size) {
        for (int row = 1; row <= size; row++) {
            printRow(size - row, row);
            System.out.println();
        }
    }

    private static void printBottom(int size) {
        for (int row = 1; row <= size - 1; row++) {
            printRow(row, size - row);
            System.out.println();
        }
    }

    private static void printRow(int countOfSpaces, int countOfStars) {
        for (int space = 1; space <= countOfSpaces; space++) {
            System.out.print(" ");
        }
        for (int star = 1; star <= countOfStars; star++) {
            System.out.print("* ");
        }
    }
}
