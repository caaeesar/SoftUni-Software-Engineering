package Exams.Final._04_;

import java.util.Arrays;
import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfTerritory = Integer.parseInt(scanner.nextLine());
        String[][] territory = new String[sizeOfTerritory][sizeOfTerritory];
        for (int i = 0; i < sizeOfTerritory; i++) {
            territory[i] = Arrays.stream(scanner.nextLine().split("")).toArray(String[]::new);
        }

        int mouseRow = -1;
        int mouseCol = -1;
        for (int r = 0; r < sizeOfTerritory; r++) {
            for (int c = 0; c < sizeOfTerritory; c++) {

                String current = territory[r][c];
                if (current.equals("M")) {
                    mouseRow = r;
                    mouseCol = c;
                    break;
                }
            }
        }

        boolean isOut = false;
        int eatenCheeses = 0;

        String command = scanner.nextLine();

        while (!"end".equals(command)) {

            switch (command) {

                case "up":
                    if (isInBounds(territory, mouseRow - 1, mouseCol)) {

                        if (territory[mouseRow - 1][mouseCol].equals("c")) {
                            eatenCheeses++;
                            territory[mouseRow][mouseCol] = "-"; // move
                            mouseRow--;
                            territory[mouseRow][mouseCol] = "M"; // eat

                        } else if (territory[mouseRow - 1][mouseCol].equals("B")) {

                            territory[mouseRow][mouseCol] = "-";
                            territory[mouseRow - 1][mouseCol] = "-"; // disappear bonus
                            mouseRow -= 2;
                            territory[mouseRow][mouseCol] = "M"; // move

                        } else {

                            territory[mouseRow][mouseCol] = "-";
                            mouseRow--;
                            territory[mouseRow][mouseCol] = "M";

                        }

                    } else {
                        isOut = true;
                    }
                    break;

                case "down":
                    if (isInBounds(territory, mouseRow + 1, mouseCol)) {

                        if (territory[mouseRow + 1][mouseCol].equals("c")) {

                            eatenCheeses++;
                            territory[mouseRow][mouseCol] = "-"; // move
                            mouseRow++;
                            territory[mouseRow][mouseCol] = "M"; // eat

                        } else if (territory[mouseRow + 1][mouseCol].equals("B")) {

                            territory[mouseRow][mouseCol] = "-";
                            territory[mouseRow + 1][mouseCol] = "-"; // disappear bonus
                            mouseRow += 2;
                            territory[mouseRow][mouseCol] = "M"; // move

                        } else {

                            territory[mouseRow][mouseCol] = "-";
                            mouseRow++;
                            territory[mouseRow][mouseCol] = "M";

                        }

                    } else {
                        isOut = true;
                    }
                    break;

                case "left":
                    if (isInBounds(territory, mouseRow, mouseCol - 1)) {

                        if (territory[mouseRow][mouseCol - 1].equals("c")) {

                            eatenCheeses++;
                            territory[mouseRow][mouseCol] = "-"; // move
                            mouseCol--;
                            territory[mouseRow][mouseCol] = "M"; // eat

                        } else if (territory[mouseRow][mouseCol - 1].equals("B")) {

                            territory[mouseRow][mouseCol] = "-";
                            territory[mouseRow][mouseCol - 1] = "-"; // disappear bonus
                            mouseCol -= 2;
                            territory[mouseRow][mouseCol] = "M"; // move

                        } else {

                            territory[mouseRow][mouseCol] = "-";
                            mouseCol--;
                            territory[mouseRow][mouseCol] = "M";

                        }

                    } else {
                        isOut = true;
                    }
                    break;
                case "right":
                    if (isInBounds(territory, mouseRow, mouseCol + 1)) {

                        if (territory[mouseRow][mouseCol + 1].equals("c")) {

                            eatenCheeses++;
                            territory[mouseRow][mouseCol] = "-"; // move
                            mouseCol++;
                            territory[mouseRow][mouseCol] = "M"; // eat

                        } else if (territory[mouseRow][mouseCol + 1].equals("B")) {

                            territory[mouseRow][mouseCol] = "-";
                            territory[mouseRow][mouseCol + 1] = "-"; // disappear bonus
                            mouseCol += 2;
                            territory[mouseRow][mouseCol] = "M"; // move

                        } else {

                            territory[mouseRow][mouseCol] = "-";
                            mouseCol++;
                            territory[mouseRow][mouseCol] = "M";

                        }

                    } else {
                        isOut = true;
                    }
                    break;
            }

            if (isOut) {
                territory[mouseRow][mouseCol] = "-";
                System.out.println("Where is the mouse?");
                break;
            }

            command = scanner.nextLine();
        }

        if (eatenCheeses >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", eatenCheeses);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - eatenCheeses);
        }

        for (String[] arr : territory) {
            for (String element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }

    }

    private static boolean isInBounds(String[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix.length;
    }
}
