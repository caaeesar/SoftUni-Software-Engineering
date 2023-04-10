package NestedLoops.moreExercise.DrawingFiguresWithLoops;

import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

      /*  int n = Integer.parseInt(scanner.nextLine());

        for (int space = 1; space <= n + 1; space++) {
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();

        for (int row = 1; row <= n; row++) {

            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
                if (star == row) {
                    System.out.print(" | ");
                }
            }
            for (int star = 1; star <= row;star++) {
                System.out.print("*");
            }
            System.out.println();
        } */

        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < n + 1; row++) {

            String space = repeatString(" ", n - row);
            String star = repeatString("*", row);

            String currentRow = space + star + " | " + star;
            System.out.println(currentRow);
        }
    } static String repeatString (String str, int count) {
        String text = "";
        for (int i = 1; i <= count; i++) {
            text += str;
        }
        return text;
    }
}
