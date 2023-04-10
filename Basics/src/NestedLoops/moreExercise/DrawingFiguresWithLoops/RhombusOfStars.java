package NestedLoops.moreExercise.DrawingFiguresWithLoops;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);


        int input = Integer.parseInt(scanner.nextLine()); // 3

        for (int row = 1; row <= input; row++) {

            for (int space = 1; space <= input - row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= row; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int row = 1; row <= input - 1; row++) {

            for (int space = 1; space <= row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= input - row; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
