package myExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _02_ {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] playgroundDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = playgroundDimensions[0];
        int cols = playgroundDimensions[1];

        String[][] playground = new String[rows][cols];
        int playerRow = -1;
        int playerCol = -1;

        for (int i = 0; i < rows; i++) {
            playground[i] = Arrays.stream(scanner.nextLine().split(" ")).toArray(String[]::new);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (playground[r][c].equals("B")) {
                    playerRow = r;
                    playerCol = c;
                    break;
                }
            }
        }

        int moves = 0;
        int touchedOpponents = 0;

        String command = scanner.nextLine();
        while (!"Finish".equals(command)) {

            switch (command) {

                case "up":
                    if (playerRow - 1 >= 0) {
                        playground[playerRow][playerCol] = "-";
                        playerRow--;
                    }
                    break;

                case "down":
                    if (playerRow + 1 < rows) {
                        playground[playerRow][playerCol] = "-";
                        playerRow++;
                    }
                    break;

                case "left":
                    if (playerCol - 1 >= 0) {
                        playground[playerRow][playerCol] = "-";
                        playerCol--;
                    }
                    break;

                case "right":
                    if (playerCol + 1 < cols) {
                        playground[playerRow][playerCol] = "-";
                        playerCol++;
                    }
                    break;

            }

            if (playground[playerRow][playerCol].equals("P")) {
                touchedOpponents++;
                moves++;
                playground[playerRow][playerCol] = "B";
                if (touchedOpponents == 3) {
                    break;
                }
            } else if (playground[playerRow][playerCol].equals("-")) {
                moves++;
                playground[playerRow][playerCol] = "B";
            } else if (playground[playerRow][playerCol].equals("O")) {
                switch (command){
                    case "up":
                        playerRow++;
                        break;
                    case "down":
                        playerRow--;
                        break;
                    case "left":
                        playerCol++;
                        break;
                    case "right":
                        playerCol--;
                        break;
                }
            }

            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchedOpponents, moves);

    }
}
