package MultidimensionalArrays.exercises;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class TheMatrix {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        int rows = size[0];
        int cols = size[1];

        String[][] matrix = new String[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(" "))
                    .toArray(String[]::new);
        }
        String fillChar = scanner.nextLine();
        int[] coordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startRow = coordinates[0];
        int startCol = coordinates[1];

        String startChar = matrix[startRow][startCol];

        fill(matrix, startRow, startCol, fillChar, startChar);

        for (String[] arr : matrix) {
            for (String element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
    //todo rewrite
    //DFS // recursion
    private static void fill(String[][] matrix, int row, int col, String fillChar, String startChar) {
        if (!matrix[row][col].equals(startChar)) {
            return;
        }

        matrix[row][col] = fillChar;

        if (row + 1 < matrix.length) { // down
            fill(matrix, row + 1, col, fillChar, startChar);
        }

        if (row - 1 >= 0) { // up
            fill(matrix, row - 1, col, fillChar, startChar);
        }

        if (col + 1 < matrix[row].length) { // right
            fill(matrix, row, col + 1, fillChar, startChar);
        }

        if (col - 1 >= 0) { // left
            fill(matrix, row, col - 1, fillChar, startChar);
        }
    }
}