package MultidimensionalArrays.lab;

import java.util.Scanner;

public class FindTheRealQueen2 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[][] board = readMatrix(scanner);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col].equals("q") && isValidQueen(row, col, board)) {
                    System.out.print(row + " " + col);
                    return;
                }
            }
        }

    }

    private static boolean isValidQueen(int row, int col, String[][] board) {
        // -1 -> намалям с 1
        // 1 -> увеличавам с 1
        // 0 -> първоначалната позиция
        // 3x3 пъти ще се повтори външния цикъл -> 8 посоки + текущата ми позиция

        for (int rowDirection = -1; rowDirection <= 1; rowDirection++) {
            for (int colDirection = -1; colDirection <= 1; colDirection++) {

                // 1-ва итерация -> up-left       = row-- col--
                // 2-ра итерация -> up            = row-- col(same)
                // 3-та итерация -> up-right      = row-- col++
                // 4-та итерация -> left          = row(same) col--
                // 5-та итерация -> same position = row(same) col(same)
                // 6-та итерация -> right         = row(same) col++
                // 7-ма итерация -> down-left     = row++ col--
                // 8-ма итерация -> down          = row++ col(same)
                // 9-та итерация -> down-right    = row++ col++

                if (rowDirection == 0 && colDirection == 0) { // значи сме на текущата позиция
                    continue;
                }

                int currentRow = row + rowDirection;
                int currentCol = col + colDirection;

                boolean validPosition = isValidPosition(board, currentRow, currentCol);

                while (validPosition) {

                    if (board[currentRow][currentCol].equals("q")) {
                        return false;
                    }
                    currentRow = currentRow + rowDirection;
                    currentCol = currentCol + colDirection;
                    validPosition = isValidPosition(board, currentRow, currentCol);
                }
            }
        }
        return true;
    }

    private static boolean isValidPosition(String[][] board, int currentRow, int currentCol) {
        return currentRow >= 0 && currentRow < board.length &&
                currentCol >= 0 && currentCol < board.length;
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
}
