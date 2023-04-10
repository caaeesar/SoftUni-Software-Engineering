package Exams.Final._03_;

import java.util.Scanner;
//todo
public class PawnWars {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessboard = new char[8][8];
        int wPawnRow = -1;
        int wPawnCol = -1;
        int bPawnRow = -1;
        int bPawnCol = -1;

        for (int r = 0; r < chessboard.length; r++) {

            String currentLine = scanner.nextLine();
            for (int c = 0; c < currentLine.length(); c++) {

                char symbol = currentLine.charAt(c);
                if (symbol == 'w') {
                    wPawnRow = r;
                    wPawnCol = c;
                } else if (symbol == 'b') {
                    bPawnRow = r;
                    bPawnCol = c;
                }
                chessboard[r][c] = symbol;
            }
        }

        boolean whiteIsReach = false;
        boolean blackIsReach = false;

        while (!whiteIsReach && !blackIsReach) {

            if (wPawnRow + 1 < chessboard.length) {
                //todo move
                chessboard[wPawnRow][wPawnCol] = '-';
                wPawnRow++;
                chessboard[wPawnRow][wPawnCol] = 'w';
            } else {
                whiteIsReach = true;
            }

            if (bPawnRow - 1 > 0) {
                //todo move
                chessboard[bPawnRow][bPawnCol] = '-';
                bPawnRow--;
                chessboard[bPawnRow][bPawnCol] = 'b';
            } else {
                blackIsReach = true;
            }

            boolean isWhiteCapture = checkDiagonally(chessboard, "White", wPawnRow, wPawnCol);
            boolean isBlackCapture = checkDiagonally(chessboard, "Black", bPawnRow, bPawnCol);

            if (isWhiteCapture || isBlackCapture) {
                break;
            }
        }

        char[] ranks = {'8', '7', '6', '5', '4', '3', '2', '1'};
        char[] column = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        if (whiteIsReach) {
            String coordinates = column[wPawnCol] + "" + ranks[wPawnRow];
            System.out.printf("Game over! White pawn is promoted to a queen at %s.", coordinates);
        }
        if (blackIsReach) {
            String coordinates = column[bPawnCol] + "" + ranks[bPawnRow];
            System.out.printf("Game over! Black pawn is promoted to a queen at %s.", coordinates);
        }



    }

    private static boolean checkDiagonally(char[][] chessboard, String pawn, int row, int col) {

        char[] ranks = {'8', '7', '6', '5', '4', '3', '2', '1'};
        char[] column = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        boolean isCapture = false;
        int coordinateRow = -1;
        int coordinateCol = -1;
        //up-left
        if (isInBounds(chessboard, row + 1, col - 1) && chessboard[row + 1][col - 1] != '-') {
            coordinateRow = row + 1;
            coordinateCol = col - 1;
            isCapture = true;
        }
        //up-right
        if (isInBounds(chessboard, row + 1, col + 1) && chessboard[row + 1][col + 1] != '-') {
            coordinateRow = row + 1;
            coordinateCol = col + 1;
            isCapture = true;
        }
        //down-left
        if (isInBounds(chessboard, row - 1, col - 1) && chessboard[row - 1][col - 1] != '-') {
            coordinateRow = row - 1;
            coordinateCol = col - 1;
            isCapture = true;
        }
        //down-right
        if (isInBounds(chessboard, row - 1, col + 1) && chessboard[row - 1][col + 1] != '-') {
            coordinateRow = row - 1;
            coordinateCol = col + 1;
            isCapture = true;
        }
        if (isCapture) {
            String coordinates = column[coordinateCol] + "" + ranks[coordinateRow];
            System.out.printf("Game over! %s capture on %s.", pawn, coordinates);
        }
        return isCapture;
    }

    private static boolean isInBounds(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}
