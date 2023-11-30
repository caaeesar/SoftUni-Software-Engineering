package WorkingWithAbstraction.exercises.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final String STOP_COMMAND = "Let the Force be with you";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = dimensions[0];
        int col = dimensions[1];

        int[][] galaxy = new int[row][col];
        fillGalaxyMatrix(row, col, galaxy);

        String input = scanner.nextLine();
        long sum = 0;

        while (!input.equals(STOP_COMMAND)) {

            int[] playerCoordinates = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            moveEvil(galaxy, evilRow, evilCol);

            int playerRow = playerCoordinates[0];
            int playerCol = playerCoordinates[1];

            sum = movePlayerAndCollectStars(galaxy, playerRow, playerCol, sum);

            input = scanner.nextLine();
        }

        System.out.println(sum);
    }

    private static long movePlayerAndCollectStars(int[][] galaxy, int playerRow, int playerCol, long sum) {
        while (playerRow >= 0 && playerCol < galaxy[1].length) {
            if (isInGalaxy(playerRow, playerCol, galaxy)) {
                sum += galaxy[playerRow][playerCol];
            }
            playerCol++;
            playerRow--;
        }
        return sum;
    }

    private static void moveEvil(int[][] galaxy, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {

            if (isInGalaxy(evilRow, evilCol, galaxy)) {
                destroyingCells(galaxy, evilRow, evilCol);
            }
            evilRow--;
            evilCol--;
        }
    }

    private static void destroyingCells(int[][] galaxy, int evilRow, int evilCol) {
        galaxy[evilRow][evilCol] = 0;
    }

    private static boolean isInGalaxy(int row, int col, int[][] galaxy) {
        return row >= 0 && row < galaxy.length && col >= 0 && col < galaxy[row].length;
    }

    private static void fillGalaxyMatrix(int row, int col, int[][] galaxy) {
        int value = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                galaxy[r][c] = value++;
            }
        }
    }
}

