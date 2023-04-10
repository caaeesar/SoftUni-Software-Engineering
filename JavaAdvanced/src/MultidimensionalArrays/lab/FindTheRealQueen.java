package MultidimensionalArrays.lab;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[][] board = readMatrix(scanner);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col].equals("q") && isValidQueenPosition(row, col, board)) {
                    System.out.print(row + " " + col);
                    return;
                }
            }
        }
    }

    private static String[][] readMatrix(Scanner scanner) {
        String[][] matrix = new String[8][8];
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                matrix[r][c] = scanner.next();
            }
        }
        return matrix;
    }

    private static boolean isValidQueenPosition(int row, int col, String[][] board) {

        //up-left -> row-- col--
        int currentRow = row;
        int currentCol = col;
        while (currentRow != 0 && currentCol != 0) {
            if (board[--currentRow][--currentCol].equals("q")) {
                return false;
            }
        }

        //up -> row-- col same as "q" position
        currentRow = row;
        while (currentRow != 0) {
            if (board[--currentRow][col].equals("q")) {
                return false;
            }
        }

        //up-right -> row-- col++
        currentRow = row;
        currentCol = col;
        while (currentRow != 0 && currentCol != board[currentRow].length - 1) {
            if (board[--currentRow][++currentCol].equals("q")) {
                return false;
            }
        }

        //right -> same row col++
        currentCol = col;
        while (currentCol != board[row].length - 1) {
            if (board[row][++currentCol].equals("q")) {
                return false;
            }
        }

        //left -> same row col--
        currentCol = col;
        while (currentCol != 0) {
            if (board[row][--currentCol].equals("q")) {
                return false;
            }
        }

        //down-left -> row++ col--
        currentRow = row;
        currentCol = col;
        while (currentCol != 0 && currentRow != board.length - 1) {
            if (board[++currentRow][--currentCol].equals("q")) {
                return false;
            }
        }

        //down-right -> row++ col++
        currentRow = row;
        currentCol = col;
        while (currentRow != board.length - 1 && currentCol != board[currentRow].length - 1) {
            if (board[++currentRow][++currentCol].equals("q")) {
                return false;
            }
        }

        //down -> row++ col same
        currentRow = row;
        while (currentRow != board.length - 1) {
            if (board[++currentRow][col].equals("q")) {
                return false;
            }
        }
        return true;
    }
}
