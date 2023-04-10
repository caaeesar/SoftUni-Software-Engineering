package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] matrix1 = readMatrix(rows, cols, scanner);
        String[][] matrix2 = readMatrix(rows, cols, scanner);

        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (!matrix1[r][c].equals(matrix2[r][c])) {
                    matrix[r][c] = "*";
                } else {
                    matrix[r][c] = matrix1[r][c];
                }
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] rows : matrix) {
            for (String col : rows) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(int rows, int cols, Scanner scanner) {
        String[][] matrix = new String[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = scanner.next();
            }
        }
        return matrix;
    }
}
