package MultidimensionalArrays.exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        int[][] matrix = readMatrix(scanner, rows, cols);


        //започваме от последния ред:
        int startRow = rows - 1;
        // започваме от последната колона:
        int startCol = cols - 1;

        while (startRow != -1) {
            int printRow = startRow;
            int printCol = startCol;
            while (printCol < cols && printRow >= 0) {
                System.out.print(matrix[printRow--][printCol++] + " ");
            }
            System.out.println();
            startCol--;
            if (startCol == -1) {
                startCol = 0;
                startRow--;
            }
        }
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
