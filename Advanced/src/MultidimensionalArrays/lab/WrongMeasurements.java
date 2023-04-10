package MultidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;
public class WrongMeasurements {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] copyMatrix = deepCopyMatrix(matrix);

        int wrongValue = matrix[scanner.nextInt()][scanner.nextInt()];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int current = matrix[r][c];
                if (current == wrongValue) {
                    int newValue = getValue(r, c, matrix, wrongValue);
                    copyMatrix[r][c] = newValue;
                }
            }
        }
        for (int[] arr : copyMatrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int getValue(int currentRow, int currentCol, int[][] matrix, int wrongValue) {
        int upElement = getUpElement(matrix, currentRow, currentCol, wrongValue);
        int downElement = getDownElement(matrix, currentRow, currentCol, wrongValue);
        int leftElement = getLeftElement(matrix, currentRow, currentCol, wrongValue);
        int rightElement = getRightElement(matrix, currentRow, currentCol, wrongValue);
        return upElement + downElement + leftElement + rightElement;
    }

    private static int getRightElement(int[][] matrix, int currentRow, int currentCol, int wrongValue) {
        int newCol = currentCol + 1;
        if (isInBounds(matrix, currentRow, newCol) && matrix[currentRow][newCol] != wrongValue) {
            return matrix[currentRow][newCol];
        }
        return 0;
    }

    private static int getLeftElement(int[][] matrix, int currentRow, int currentCol, int wrongValue) {
        int newCol = currentCol - 1;
        if (isInBounds(matrix, currentRow, newCol) && matrix[currentRow][newCol] != wrongValue) {
            return matrix[currentRow][newCol];
        }
        return 0;
    }

    private static int getDownElement(int[][] matrix, int currentRow, int currentCol, int wrongValue) {
        int newRow = currentRow - 1;
        if (isInBounds(matrix, newRow, currentCol) && matrix[newRow][currentCol] != wrongValue) {
            return matrix[newRow][currentCol];
        }
        return 0;
    }

    private static int getUpElement(int[][] matrix, int currentRow, int currentCol, int wrongValue) {
        int newRow = currentRow + 1;
        if (isInBounds(matrix, newRow, currentCol) && matrix[newRow][currentCol] != wrongValue) {
            return matrix[newRow][currentCol];
        }
        return 0;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }


    private static int[][] deepCopyMatrix(int[][] matrix) {
        int[][] copyMatrix = new int[matrix.length][];
        for (int r = 0; r < matrix.length; r++) {
            int[] originalArr = matrix[r];
            copyMatrix[r] = Arrays.copyOf(originalArr, originalArr.length);
        }
        return copyMatrix;
    }
}

