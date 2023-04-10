package Exams.Retake._03_;

import java.util.Scanner;

public class Armory {

    public static final String UP = "up";
    public static final String DOWN = "down";
    public static final String RIGHT = "right";
    public static final String LEFT = "left";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int armorySize = Integer.parseInt(scanner.nextLine());
        String[][] armory = new String[armorySize][armorySize];
        int rowIndex = -1;
        int colIndex = -1;
        int secondMirrorRow = -1;
        int secondMirrorCol = -1;

        boolean isFirstMirror = true;

        int row = 0;
        while (row < armorySize) {
            String currentLine = scanner.next();
            for (int index = 0; index < currentLine.length(); index++) {
                char symbol = currentLine.charAt(index);
                if (symbol == 'A') {
                    rowIndex = row;
                    colIndex = index;
                } else if (symbol == 'M' && isFirstMirror) {
                    isFirstMirror = false;
                } else if (symbol == 'M' && !isFirstMirror) {
                    secondMirrorRow = row;
                    secondMirrorCol = index;
                }
                armory[row][index] = String.valueOf(symbol);
            }
            row++;
        }
        scanner.nextLine();
        int totalGold = 0;
        boolean isLeave = false;
        boolean isEnoughMoney = false;
        while (scanner.hasNextLine()) {

            String command = scanner.nextLine();
            switch (command) {
                case UP:
                    if (rowIndex - 1 >= 0) {
                        armory[rowIndex][colIndex] = "-";
                        rowIndex--;
                    } else {
                        isLeave = true;
                    }
                    break;
                case DOWN:
                    if (rowIndex + 1 < armorySize) {
                        armory[rowIndex][colIndex] = "-";
                        rowIndex++;
                    } else {
                        isLeave = true;
                    }
                    break;
                case RIGHT:
                    if (colIndex + 1 < armorySize) {
                        armory[rowIndex][colIndex] = "-";
                        colIndex++;
                    } else {
                        isLeave = true;
                    }
                    break;
                case LEFT:
                    if (colIndex - 1 >= 0) {
                        armory[rowIndex][colIndex] = "-";
                        colIndex--;
                    } else {
                        isLeave = true;
                    }
                    break;
            }
            if (isLeave) {
                armory[rowIndex][colIndex] = "-";
                break;
            }
            if (armory[rowIndex][colIndex].equals("M")) {
                armory[rowIndex][colIndex] = "-";
                rowIndex = secondMirrorRow;
                colIndex = secondMirrorCol;
            } else if (!armory[rowIndex][colIndex].equals("-")) { // price
                int currentPrice = Integer.parseInt(armory[rowIndex][colIndex]);
                totalGold += currentPrice;
                if (totalGold >= 65) {
                    isEnoughMoney = true;
                }
            }
            armory[rowIndex][colIndex] = "A";
            if (isEnoughMoney) {
                break;
            }
        }

        if (isEnoughMoney) {
            System.out.println("Very nice swords, I will come back for more!");
        }
        if (isLeave) {
            System.out.println("I do not need more swords!");
        }
        System.out.printf("The king paid %d gold coins.\n", totalGold);

        for (int r = 0; r < armorySize; r++) {
            for (int c = 0; c < armorySize; c++) {
                System.out.print(armory[r][c]);
            }
            System.out.println();
        }

    }
}
