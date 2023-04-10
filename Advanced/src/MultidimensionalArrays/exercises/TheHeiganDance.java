package MultidimensionalArrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // char[][] field = new char[15][15];
        // exact in the center:
        int[] playerPosition = new int[2];
        playerPosition[0] = 7;
        playerPosition[1] = 7;

        int playerHealth = 18_500;
        double bossHealth = 3_000_000;
        String lastMagic = "";
        boolean isActiveCloud = false;

        double damage = Double.parseDouble(scanner.nextLine());

        while (playerHealth > 0 && bossHealth > 0) { // докато играчът е жив

            bossHealth -= damage;
            if (isActiveCloud) {
                playerHealth -= 3_500;
                isActiveCloud = false;
            }

            if (playerHealth < 0 || bossHealth < 0) {
                break;
            }

            String[] parts = Arrays.stream(scanner.nextLine().split(" "))
                    .toArray(String[]::new);

            String magic = parts[0];

            int targetRow = Integer.parseInt(parts[1]);
            int targetCol = Integer.parseInt(parts[2]);
            int playerRow = playerPosition[0];
            int playerCol = playerPosition[1];

            // проверяваме дали е в обсега на магията
            boolean isPlayerDamaged = isHit(playerRow, playerCol, targetRow, targetCol);
            if (isPlayerDamaged) {

                // проверяваме дали може да избяга
                boolean canMove = movePlayer(playerPosition, targetRow, targetCol);
                if (!canMove) {

                    switch (magic) {
                        case "Cloud":
                            playerHealth -= 3_500;
                            isActiveCloud = true;
                            break;
                        case "Eruption":
                            playerHealth -= 6_000;
                            break;
                    }
                    lastMagic = magic;
                }

            }
        }
        lastMagic = lastMagic.equals("Cloud") ? "Plague Cloud" : lastMagic;

        if (bossHealth <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", bossHealth);
        }

        if (playerHealth <= 0) {
            System.out.printf("Player: Killed by %s%n", lastMagic);
        } else {
            System.out.printf("Player: %d%n", playerHealth);
        }

        System.out.printf("Final position: %d, %d", playerPosition[0], playerPosition[1]);
    }

    public static boolean isInBound(int row, int col) {
        return row >= 0 && row < 15 && col >= 0 && col < 15;
    }

    private static boolean movePlayer(int[] playerPosition, int targetRow, int targetCol) {
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];

        if (playerRow == targetRow && playerCol == targetCol) {
            return false;
        }

        boolean isMove = false;
        if (isInBound(playerRow - 1, playerCol)   // up
                && !isHit(playerRow - 1, playerCol, targetRow, targetCol)) {
            playerPosition[0]--;
            isMove = true;
        } else if (isInBound(playerRow + 1, playerCol)  //down
                && !isHit(playerRow + 1, playerCol, targetRow, targetCol)) {
            playerPosition[0]++;
            isMove = true;
        } else if (isInBound(playerRow, playerCol - 1)  // left
                && !isHit(playerRow, playerCol - 1, targetRow, targetCol)) {
            playerPosition[1]--;
            isMove = true;
        } else if (isInBound(playerRow, playerCol + 1) //right
                && !isHit(playerRow, playerCol + 1, targetRow, targetCol)) {
            playerPosition[1]++;
            isMove = true;
        }
        return isMove;
    }

    private static boolean isHit(int playerRow, int playerCol, int targetRow, int targetCol) {
        // магията поразява 3х3 матрица
        return playerRow >= targetRow - 1 && playerRow <= targetRow + 1 &&
                playerCol >= targetCol - 1 && playerCol <= targetCol + 1;
    }
}
