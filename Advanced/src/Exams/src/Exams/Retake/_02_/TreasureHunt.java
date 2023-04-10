package Exams.Retake._02_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
//fixme
    public static final String FINISH = "Finish";
    public static final String UP = "up";
    public static final String LEFT = "left";
    public static final String DOWN = "down";
    public static final String RIGHT = "right";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] fieldDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = fieldDimensions[0];
        int cols = fieldDimensions[1];
        String[][] field = new String[rows][cols];

        for (int i = 0; i < field.length; i++) {
            field[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .toArray(String[]::new);
        }

        int currentRow = -1;
        int currentCol = -1;

        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {

                if (field[r][c].equals("Y")) {
                    currentRow = r;
                    currentCol = c;
                }
            }
        }

        List<String> path = new ArrayList<>();
        boolean isFound = false;
        int nextRow;
        int nextCol;
        String command = scanner.nextLine();
        while (!FINISH.equals(command)) {

            switch (command) {
                case UP:
                    nextRow = currentRow - 1;
                    if (isInBounds(field, nextRow, currentCol)) {

                        if (!field[nextRow][currentCol].equals("T")) {
                            currentRow--;
                        }
                    } else {
                        if (nextRow < 0) {
                            nextRow = 0;
                        }
                        if (!field[nextRow][currentCol].equals("T")) {
                            currentRow = nextRow;
                        }
                    }
                    break;
                case DOWN:
                    nextRow = currentRow + 1;
                    if (isInBounds(field, nextRow, currentCol)) {

                        if (!field[nextRow][currentCol].equals("T")) {
                            currentRow++;
                        }

                    } else {
                        if (nextRow >= field.length) {
                            nextRow = field.length - 1;
                        }

                        if (!field[nextRow][currentCol].equals("T")) {
                            currentRow = nextRow;
                        }
                    }
                    break;
                case LEFT:
                    nextCol = currentCol - 1;
                    if (isInBounds(field, currentRow, nextCol)) {

                        if (!field[currentRow][nextCol].equals("T")) {
                            currentCol--;
                        }

                    } else {
                        if (nextCol < 0) {
                            nextCol = 0;
                        }

                        if (!field[currentRow][nextCol].equals("T")) {
                            currentCol = nextCol;
                        }
                    }
                    break;
                case RIGHT:
                    nextCol = currentCol + 1;
                    if (isInBounds(field, currentRow, nextCol)) {

                        if (!field[currentRow][nextCol].equals("T")) {
                            currentCol++;
                        }
                    } else {
                        if (nextCol >= field.length) {
                            nextCol = field.length - 1;
                        }

                        if (!field[currentRow][nextCol].equals("T")) {
                            currentCol = nextCol;
                        }
                    }
                    break;
            }
            path.add(command);
            if (field[currentRow][currentCol].equals("X")) {
                isFound = true;
                break;
            }
            command = scanner.nextLine();
        }
        if (isFound) {
            System.out.println("I've found the treasure!");
            System.out.printf("The right path is %s", String.join(", ", path));
        } else {
            System.out.println("The map is fake!");
        }
    }

    private static boolean isInBounds(String[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}

