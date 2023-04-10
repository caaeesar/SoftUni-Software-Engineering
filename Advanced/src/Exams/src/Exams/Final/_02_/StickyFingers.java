package Exams.Final._02_;

import java.util.Arrays;
import java.util.Scanner;

public class StickyFingers {

    public static final String UP = "up";
    public static final String DOWN = "down";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] allCommands = Arrays.stream(scanner.nextLine().split(",")).toArray(String[]::new);

        String[][] field = new String[size][size];
        int playerXPosition = -1; // row
        int playerYPosition = -1; // col
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {

                String currentSymbol = scanner.next();
                if (!currentSymbol.equals(" ")) {

                    if (currentSymbol.equals("D")) {
                        playerXPosition = r;
                        playerYPosition = c;
                    }
                    field[r][c] = currentSymbol;
                }
            }
        }

        int totalMoney = 0;
        boolean isCaught = false;
        for (int i = 0; i < allCommands.length; i++) {

            String command = allCommands[i];

            switch (command) {
                case UP:
                    if (playerXPosition - 1 >= 0) { // in bound
                        field[playerXPosition][playerYPosition] = "+";
                        playerXPosition--;
                    } else { // out bound
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case DOWN:
                    if (playerXPosition + 1 < size) {
                        field[playerXPosition][playerYPosition] = "+";
                        playerXPosition++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case LEFT:
                    if (playerYPosition - 1 >= 0) {
                        field[playerXPosition][playerYPosition] = "+";
                        playerYPosition--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case RIGHT:
                    if (playerYPosition + 1 < size) {
                        field[playerXPosition][playerYPosition] = "+";
                        playerYPosition++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
            }

            if (field[playerXPosition][playerYPosition].equals("$")) {

                int currentMoney = playerXPosition * playerYPosition;
                System.out.printf("You successfully stole %d$.%n", currentMoney);
                totalMoney += playerXPosition * playerYPosition;

            } else if (field[playerXPosition][playerYPosition].equals("P")) {

                field[playerXPosition][playerYPosition] = "#";
                isCaught = true;
                break;

            }
            field[playerXPosition][playerYPosition] = "D";
        }

        if (isCaught) {
            System.out.printf("You got caught with %d$, and you are going to jail.\n", totalMoney);
        } else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", totalMoney);
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(field[r][c] + " ");
            }
            System.out.println();
        }
    }
}
