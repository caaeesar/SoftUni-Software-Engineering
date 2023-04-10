package Exams.Retake._01_;

import java.util.Arrays;
import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int wall = Integer.parseInt(scanner.nextLine());
        String[][] battlefield = new String[wall][];

        for (int i = 0; i < battlefield.length; i++) {
            battlefield[i] = Arrays.stream(scanner.nextLine().split(""))
                    .toArray(String[]::new);
        }

        int submarineRow = -1;
        int submarineCol = -1;
        for (int row = 0; row < battlefield.length; row++) {
            for (int col = 0; col < battlefield[row].length; col++) {

                if (battlefield[row][col].equals("S")) {
                    submarineRow = row;
                    submarineCol = col;
                    break;
                }
            }
        }

        boolean isSuccessful = false;
        int hits = 0;
        int destroyedCruiser = 0;

        while (hits < 3 && destroyedCruiser < 3) {

            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (battlefield[submarineRow - 1][submarineCol].equals("*")) {
                        hits++;
                    } else if (battlefield[submarineRow - 1][submarineCol].equals("C")) {
                        destroyedCruiser++;
                    }
                    battlefield[submarineRow - 1][submarineCol] = "-"; // set
                    battlefield[submarineRow][submarineCol] = "-"; // change previous position
                    submarineRow -= 1;
                    battlefield[submarineRow][submarineCol] = "S"; // move
                    break;
                case "down":
                    if (battlefield[submarineRow + 1][submarineCol].equals("*")) {
                        hits++;
                    } else if (battlefield[submarineRow + 1][submarineCol].equals("C")) {
                        destroyedCruiser++;
                    }
                    battlefield[submarineRow + 1][submarineCol] = "-";
                    battlefield[submarineRow][submarineCol] = "-";
                    submarineRow += 1;
                    battlefield[submarineRow][submarineCol] = "S";
                    break;
                case "left":
                    if (battlefield[submarineRow][submarineCol - 1].equals("*")) {
                        hits++;
                    } else if (battlefield[submarineRow][submarineCol - 1].equals("C")) {
                        destroyedCruiser++;
                    }
                    battlefield[submarineRow][submarineCol - 1] = "-";
                    battlefield[submarineRow][submarineCol] = "-";
                    submarineCol -= 1;
                    battlefield[submarineRow][submarineCol] = "S";
                    break;
                case "right":
                    if (battlefield[submarineRow][submarineCol + 1].equals("*")) {
                        hits++;
                    } else if (battlefield[submarineRow][submarineCol + 1].equals("C")) {
                        destroyedCruiser++;
                    }
                    battlefield[submarineRow][submarineCol + 1] = "-";
                    battlefield[submarineRow][submarineCol] = "-";
                    submarineCol += 1;
                    battlefield[submarineRow][submarineCol] = "S";
                    break;
            }
            if (destroyedCruiser == 3) {
                isSuccessful = true;
            }
        }
       // battlefield[submarineRow][submarineCol] = "S";
        if (isSuccessful) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
            print(battlefield);
        } else {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n", submarineRow, submarineCol);
            print(battlefield);
        }
    }

    private static void print(String[][] battlefield) {
        for (int r = 0; r < battlefield.length; r++) {
            for (int c = 0; c < battlefield[r].length; c++) {
                System.out.print(battlefield[r][c]);
            }
            System.out.println();
        }
    }
}
