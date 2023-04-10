package MultidimensionalArrays.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] rotationParts = scanner.nextLine().split("[()]");
        int rotationNumber = Integer.parseInt(rotationParts[1]);
        int angleOfRotation = rotationNumber % 360;

        List<String> words = new ArrayList<>();
        int maxLength = -1;
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            words.add(input);
            input = scanner.nextLine();
        }

        int rows = words.size();
        int cols = maxLength;
        char[][] matrix = new char[rows][cols];
        fillMatrix(words, matrix, rows, cols);

        switch (angleOfRotation) {
            case 0:
                for (char[] chars : matrix) {
                    for (char symbol : chars) {
                        System.out.print(symbol);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }

                break;
            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }

    private static void fillMatrix(List<String> words, char[][] matrix, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            String currentWord = words.get(r);
            for (int c = 0; c < cols; c++) {
                if (c < currentWord.length()) {
                    char symbol = currentWord.charAt(c);
                    matrix[r][c] = symbol;
                } else {
                    matrix[r][c] = ' ';
                }
            }
        }
    }
}
