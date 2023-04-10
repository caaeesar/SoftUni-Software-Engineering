package MultidimensionalArrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        String[][] matrix = readMatrix(scanner, rows);

        String input = scanner.nextLine();
        while (!"END".equals(input)) {

            String[] parts = input.split("\\s");
            String command = parts[0];

            if (parts.length == 5 && command.equals("swap")) {

                int row1 = Integer.parseInt(parts[1]);
                int col1 = Integer.parseInt(parts[2]);
                int row2 = Integer.parseInt(parts[3]);
                int col2 = Integer.parseInt(parts[4]);

                boolean isValidIndexes = validationIndex(matrix, row1, col1, row2, col2);

                if (isValidIndexes) {
                    String firstElement = matrix[row1][col1];
                    String secondElement = matrix[row2][col2];
                    swappingElements(firstElement, row1, col1, secondElement, row2, col2, matrix);
                } else {
                    System.out.println("Invalid input!");
                    input = scanner.nextLine();
                    continue;
                }

            } else {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }
            printMatrix(matrix);
            input = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] line : matrix) {
            for (String element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void swappingElements(String firstElement, int row1, int col1,
                                         String secondElement, int row2, int col2, String[][] matrix) {
        matrix[row1][col1] = secondElement;
        matrix[row2][col2] = firstElement;
    }

    private static boolean validationIndex(String[][] matrix, int row1, int col1, int row2, int col2) {
        return row1 >= 0 && row1 < matrix.length && col1 >= 0 && col1 < matrix[row1].length
                && row2 >= 0 && row2 < matrix.length && col2 >= 0 && col2 < matrix[row2].length;
    }

    private static String[][] readMatrix(Scanner scanner, int rows) {
        String[][] matrix = new String[rows][];
        for (int r = 0; r < rows; r++) {
            String[] currentLine = Arrays.stream(scanner.nextLine().split("\\s"))
                    .toArray(String[]::new);
            matrix[r] = currentLine;
        }
        return matrix;
    }
}
