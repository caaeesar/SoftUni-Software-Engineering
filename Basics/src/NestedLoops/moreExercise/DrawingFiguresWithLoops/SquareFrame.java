package NestedLoops.moreExercise.DrawingFiguresWithLoops;

import java.util.Scanner;

public class SquareFrame {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

     /*   for (int row = 1; row <= input; row++) {
            for (int colum = 1; colum <= input; colum++) {

                if (((row == 1 && colum == 1) || (row == 1 && colum == input) || (row == input && colum == 1) || (row == input && colum == input))) {
                    System.out.print("+ ");
                } else if (row > 1 && row != input && (colum == 1 || colum == input)) {
                    System.out.print("| ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        } */

        // първа част: + -- +
        System.out.print("+");
        for (int row = 1; row <= input - 2; row++) {

            System.out.print(" -");
        }
        System.out.print(" +");

        System.out.println();

        // втора част: | - - |

        for (int row = 1; row <= input - 2; row++) {

                System.out.print("|");

            for (int rows = 1; rows <= input - 2; rows++) {

                System.out.print(" -");
            }
            System.out.print(" |");
            System.out.println();
        }

        // трета част: + -- +
        System.out.print("+");
        for (int row = 1; row <= input - 2; row++) {

            System.out.print(" -");
        }
        System.out.print(" +");
    }
}
