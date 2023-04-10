package MultidimensionalArrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, n);

        int[] primaryDiagonalElements = getPrimaryElements(matrix);
        int[] secondaryDiagonalElements = getSecondaryElements(matrix);

        int primarySum = Arrays.stream(primaryDiagonalElements).sum();
        int secondarySum = Arrays.stream(secondaryDiagonalElements).sum();
        int difference = Math.abs(primarySum - secondarySum);

        System.out.print(difference);
    }

    private static int[] getSecondaryElements(int[][] matrix) {
        int[] elements = new int[matrix.length];
        int index = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (c == matrix.length - 1 - r) {
                    elements[index++] = matrix[r][c];
                }
            }
        }
      /*  int row = 0;
        int col = matrix.length - 1;
        int index = 0;
        while (row < matrix.length && col >= 0) {
            int currentElement = matrix[row++][col--];
            elements[index] = currentElement;
            index++;
        }*/
        return elements;
    }

    private static int[] getPrimaryElements(int[][] matrix) {
        int[] elements = new int[matrix.length];
        int row = 0;
        int col = 0;

        int index = 0;
        while (row < matrix.length && col < matrix.length) {
            int currentElement = matrix[row++][col++];
            elements[index] = currentElement;
            index++;
        }
        return elements;
    }

    private static int[][] readMatrix(Scanner scanner, int n) {
        int[][] matrix = new int[n][n];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
