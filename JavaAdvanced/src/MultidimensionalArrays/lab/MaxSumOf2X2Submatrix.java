package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumOf2X2Submatrix {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] sizes = Arrays.stream(scanner.nextLine().split(",\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = readMatrix(sizes[0], scanner);
        int maxSum = Integer.MIN_VALUE;
        int subRow = -1;
        int subCol = -1;

        for (int r = 0; r < matrix.length - 1; r++) {
            int currentSum = 0;
            for (int c = 0; c < matrix[r].length - 1; c++) {

                currentSum = matrix[r][c] + matrix[r][c + 1] +
                        matrix[r + 1][c] + matrix[r + 1][c + 1];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    subRow = r;
                    subCol = c;
                }
            }
        }
        System.out.println(matrix[subRow][subCol] + " " + matrix[subRow][subCol + 1]);
        System.out.println(matrix[subRow + 1][subCol] + " " + matrix[subRow + 1][subCol + 1]);
        System.out.print(maxSum);
    }

    private static int[][] readMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];
        for (int r = 0; r < rows; r++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[r] = currentRow;
        }
        return matrix;
    }
}
