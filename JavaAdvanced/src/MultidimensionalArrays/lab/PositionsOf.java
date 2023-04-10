package MultidimensionalArrays.lab;

import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.next());
        int cols = Integer.parseInt(scanner.next());
        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < matrix.length; r++) {

            for (int c = 0; c < matrix[r].length; c++) {

                matrix[r][c] = Integer.parseInt(scanner.next());
            }
        }
        int searchNumber = Integer.parseInt(scanner.next());
        boolean isFound = false;

        for (int r = 0; r < matrix.length; r++) {

            for (int c = 0; c < matrix[r].length; c++) {

                if (matrix[r][c] == searchNumber) {
                    System.out.println(r + " " + c);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.print("not found");
        }
    }
}
