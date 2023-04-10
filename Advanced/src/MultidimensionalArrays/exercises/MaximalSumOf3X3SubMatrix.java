package MultidimensionalArrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSumOf3X3SubMatrix {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        int[][] matrix = readMatrix(scanner, rows);

        int maxSum = Integer.MIN_VALUE;
        int firstSubRow = -1;
        int firstSubCol = -1;

        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {

                int currentSum = matrix[r][c] + matrix[r][c + 1] + matrix[r][c + 2]
                        + matrix[r + 1][c] + matrix[r + 1][c + 1] + matrix[r + 1][c + 2]
                        + matrix[r + 2][c] + matrix[r + 2][c + 1] + matrix[r + 2][c + 2];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    firstSubRow = r;
                    firstSubCol = c;
                }
            }
        }
        System.out.printf("Sum = %d\n", maxSum);
        System.out.println(
                matrix[firstSubRow][firstSubCol] + " " +
                        matrix[firstSubRow][firstSubCol + 1] + " " +
                        matrix[firstSubRow][firstSubCol + 2]
        );
        System.out.println(
                matrix[firstSubRow + 1][firstSubCol] + " " +
                        matrix[firstSubRow + 1][firstSubCol + 1] + " " +
                        matrix[firstSubRow + 1][firstSubCol + 2]
        );
        System.out.println(
                matrix[firstSubRow + 2][firstSubCol] + " " +
                        matrix[firstSubRow + 2][firstSubCol + 1] + " " +
                        matrix[firstSubRow + 2][firstSubCol + 2]
        );
    }

    private static int[][] readMatrix(Scanner scanner, int rows) {
        int[][] matrix = new int[rows][];
        for (int r = 0; r < rows; r++) {
            int[] currentLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[r] = currentLine;
        }
        return matrix;
    }
}
