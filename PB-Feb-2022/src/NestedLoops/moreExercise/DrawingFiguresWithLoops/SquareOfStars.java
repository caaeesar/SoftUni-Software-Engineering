package NestedLoops.moreExercise.DrawingFiguresWithLoops;

import java.util.Scanner;

public class SquareOfStars {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int row = 1; row <= input; row++) {

            for (int colum = 1; colum <= input; colum++) {

                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
