package MultidimensionalArrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] input = Arrays.stream(scanner.nextLine().split(",\\s+")).toArray(String[]::new);

        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];

        switch (pattern) {
            case "A":
                fillMatrixByPatternA(matrix);
                break;
            case "B":
                fillMatrixByPatternB(matrix);
                break;
        }
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixByPatternB(int[][] matrix) {
        int countCol = 1;
        int value = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (countCol % 2 == 0) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = value++;
                }
            } else {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = value++;
                }
            }
            countCol++;
        }
    }

    private static void fillMatrixByPatternA(int[][] matrix) {
        int value = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = value++;
            }
        }
    }
}
        /*String[] input = Arrays.stream(scanner.nextLine().split(",\\s+")).toArray(String[]::new);
        int size = Integer.parseInt(input[0]);
        int[][] matrix = new int[size][size];

        int currentElement = 1;
        int row = 0;
        int col = 0;

        String pattern = input[1];
        switch (pattern) {
            case "A":
                *//*  r c
 * [0;0]  [0;1] [0;2]
 * [1;0]  [1;1] [1;2]
 * [2;0]  [2;1] [2;2]
 *//*
                while (currentElement <= size * size) {
                    matrix[row][col] = currentElement;
                    row++;
                    currentElement++;
                    if (row == size) {
                        row = 0;
                        col++;
                    }
                }
            case "B":
                *//*  r c
 * [0;0] [2;1] [0;2]
 * [1;0] [1;1] [1;2]
 * [2;0] [0;1] [2;2]
 *//*
                boolean isEnd = false;
                while (currentElement <= size * size) {
                    matrix[row][col] = currentElement;
                    if (!isEnd) {
                        row++;
                    } else {
                        row--;
                        if (row < 0) {
                            row = 0;
                            col++;
                            isEnd = false;
                        }
                    }
                    currentElement++;
                    if (row == size) {
                        row = size - 1;
                        col++;
                        isEnd = true;
                    }
                }
        }
        for (int[] rows : matrix) {
            for (int column : rows) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }*/
