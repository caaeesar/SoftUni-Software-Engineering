package MultidimensionalArrays.exercises;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.next());
        int cols = Integer.parseInt(scanner.next());

        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                int firstAndLastLettersIndex = r;
                int middleLetterIndex = r + c;

                char firstLastLetter = getAsciiCode(firstAndLastLettersIndex);
                char middleLetter = getAsciiCode(middleLetterIndex);

                String currentTriple = String.format("%c%c%c", firstLastLetter, middleLetter, firstLastLetter);

                matrix[r][c] = currentTriple;
            }
        }
        for (String[] line : matrix) {
            for (String currentElement : line) {
                System.out.print(currentElement + " ");
            }
            System.out.println();
        }
    }

    private static char getAsciiCode(int index) {
        return (char) (97 + index);
    }
}
