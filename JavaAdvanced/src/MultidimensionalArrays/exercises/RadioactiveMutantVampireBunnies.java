package MultidimensionalArrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // read input and fill matrix
        int[] lairSize = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = lairSize[0];
        int cols = lairSize[1];
        String[][] lair = readMatrix(scanner, rows, cols);

        // find player position
        int playerRow = -1;
        int playerCol = -1;
        boolean isFindPosition = false;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (lair[r][c].equals("P")) {
                    playerRow = r;
                    playerCol = c;
                    isFindPosition = true;
                    break;
                }
            }
            if (isFindPosition) {
                break;
            }
        }

        String commands = scanner.nextLine();
        boolean isDead = false;
        boolean isAway = false;

        for (int position = 0; position < commands.length(); position++) {
            char currentMove = commands.charAt(position);

            // moving player
            switch (currentMove) {
                case 'L':
                    if (playerCol - 1 < 0) { // run away out of lair
                        isAway = true;
                        lair[playerRow][playerCol] = ".";
                    } else {  // in lair
                        if (lair[playerRow][playerCol - 1].equals(".")) { // move left
                            lair[playerRow][playerCol] = ".";
                            lair[playerRow][playerCol - 1] = "P";
                            playerCol--;     // change position
                        } else {
                            isDead = true;
                            lair[playerRow][playerCol] = ".";
                            playerCol--;
                        }
                    }
                    break;
                case 'R':
                    if (playerCol + 1 == cols) {
                        isAway = true;
                        lair[playerRow][playerCol] = ".";
                    } else {
                        if (lair[playerRow][playerCol + 1].equals(".")) { // move right
                            lair[playerRow][playerCol] = ".";
                            lair[playerRow][playerCol + 1] = "P";
                            playerCol++;  // change position
                        } else {
                            isDead = true;
                            lair[playerRow][playerCol] = ".";
                            playerCol++;
                        }
                    }
                    break;
                case 'U':
                    if (playerRow - 1 < 0) {
                        isAway = true;
                        lair[playerRow][playerCol] = ".";
                    } else {
                        if (lair[playerRow - 1][playerCol].equals(".")) { // up move
                            lair[playerRow][playerCol] = ".";
                            lair[playerRow - 1][playerCol] = "P";
                            playerRow--;  // change position
                        } else {
                            isDead = true;
                            lair[playerRow][playerCol] = ".";
                            playerRow--;
                        }
                    }
                    break;
                case 'D':
                    if (playerRow + 1 == rows) {
                        isAway = true;
                        lair[playerRow][playerCol] = ".";
                    } else {
                        if (lair[playerRow + 1][playerCol].equals(".")) { // down move
                            lair[playerRow][playerCol] = ".";
                            lair[playerRow + 1][playerCol] = "P";
                            playerRow++;  // change position
                        } else {
                            isDead = true;
                            lair[playerRow][playerCol] = ".";
                            playerRow++;
                        }
                    }
                    break;
            }

            // spread bunnies
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {

                    if (lair[r][c].equals("B")) {

                        // UP
                        if (r - 1 >= 0) { // in bound
                            if (lair[r - 1][c].equals("P")) {
                                isDead = true;
                                lair[r - 1][c] = "newB";
                            } else if (lair[r - 1][c].equals(".")) {
                                lair[r - 1][c] = "newB";
                            }
                        }

                        // DOWN
                        if (r + 1 < lair.length) { // in bound
                            if (lair[r + 1][c].equals("P")) {
                                isDead = true;
                                lair[r + 1][c] = "newB";
                            } else if (lair[r + 1][c].equals(".")) {
                                lair[r + 1][c] = "newB";
                            }
                        }

                        // LEFT
                        if (c - 1 >= 0) { // in bound
                            if (lair[r][c - 1].equals("P")) {
                                isDead = true;
                                lair[r][c - 1] = "newB";
                            } else if (lair[r][c - 1].equals(".")) {
                                lair[r][c - 1] = "newB";
                            }
                        }

                        // RIGHT
                        if (c + 1 < lair[r].length) { // in bound
                            if (lair[r][c + 1].equals("P")) {
                                isDead = true;
                                lair[r][c + 1] = "newB";
                            } else if (lair[r][c + 1].equals(".")) {
                                lair[r][c + 1] = "newB";
                            }
                        }

                    }
                }
            }
            lair = spreadBunnies(lair);
            if (isDead) {
                printMatrix(lair);
                System.out.printf("dead: %d %d", playerRow, playerCol);
                break;
            } else if (isAway) {
                printMatrix(lair);
                System.out.printf("won: %d %d", playerRow, playerCol);
                break;
            }
        }
    }

    private static void printMatrix(String[][] lair) {
        for (String[] cells : lair) {
            for (String cell : cells) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private static String[][] spreadBunnies(String[][] lair) {
        for (int r = 0; r < lair.length; r++) {
            for (int c = 0; c < lair[r].length; c++) {
                if (lair[r][c].equals("newB")) {
                    lair[r][c] = "B";
                }
            }
        }
        return lair;
    }

    private static String[][] readMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(""))
                    .toArray(String[]::new);
        }
        return matrix;
    }
}
