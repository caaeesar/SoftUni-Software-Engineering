package Exams.Final._01_;

import java.util.Arrays;
import java.util.Scanner;

public class RallyRacing {

    public static final String END = "End";
    public static final String UP = "up";
    public static final String DOWN = "down";
    public static final String RIGHT = "right";
    public static final String LEFT = "left";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfRaceRoute = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        String[][] raceRoute = new String[sizeOfRaceRoute][];

        for (int r = 0; r < raceRoute.length; r++) {
            raceRoute[r] = Arrays.stream(scanner.nextLine().split("\\s"))
                    .toArray(String[]::new);
        }

        int carRow = 0;
        int carCol = 0;

        int passedKm = 0;

        boolean isFinished = false;

        String command = scanner.nextLine();

//todo 85/100
        while (!END.equals(command)) {

            if (UP.equals(command)) {// if next position
                if (raceRoute[carRow - 1][carCol].equals("T")) {
                    passedKm += 30;
                    raceRoute[carRow - 1][carCol] = ".";
                    raceRoute[carRow][carCol] = ".";
                    for (int r = 0; r < raceRoute.length; r++) {
                        for (int c = 0; c < raceRoute[r].length; c++) {
                            if (raceRoute[r][c].equals("T")) {
                                raceRoute[r][c] = "C";
                                carRow = r;
                                carCol = c;
                            }
                        }
                    }
                } else if (raceRoute[carRow - 1][carCol].equals("F")) {
                    isFinished = true;
                    passedKm += 10;
                    raceRoute[carRow][carCol] = ".";
                    carRow--;
                    raceRoute[carRow][carCol] = "C";
                    break;
                } else {
                    passedKm += 10;
                    raceRoute[carRow][carCol] = ".";
                    carRow--;
                    raceRoute[carRow][carCol] = "C";
                }
            } else if (DOWN.equals(command)) {
                if (raceRoute[carRow + 1][carCol].equals("T")) {
                    passedKm += 30;
                    raceRoute[carRow + 1][carCol] = ".";
                    for (int r = 0; r < raceRoute.length; r++) {
                        for (int c = 0; c < raceRoute[r].length; c++) {
                            if (raceRoute[r][c].equals("T")) {
                                raceRoute[r][c] = "C";
                                carRow = r;
                                carCol = c;
                                break;
                            }
                        }
                    }
                } else if (raceRoute[carRow + 1][carCol].equals("F")) {
                    isFinished = true;
                    passedKm += 10;
                    raceRoute[carRow][carCol] = ".";
                    raceRoute[carRow + 1][carCol] = "C";
                    break;
                } else {
                    passedKm += 10;
                    raceRoute[carRow][carCol] = ".";
                    carRow++;
                    raceRoute[carRow][carCol] = "C";
                }
            } else if (RIGHT.equals(command)) {
                if (raceRoute[carRow][carCol + 1].equals("T")) {
                    passedKm += 30;
                    raceRoute[carRow][carCol + 1] = ".";
                    raceRoute[carRow][carCol] = ".";
                    for (int r = 0; r < raceRoute.length; r++) {
                        for (int c = 0; c < raceRoute[r].length; c++) {
                            if (raceRoute[r][c].equals("T")) {
                                raceRoute[r][c] = "C";
                                carRow = r;
                                carCol = c;
                                break;
                            }
                        }
                    }
                } else if (raceRoute[carRow][carCol + 1].equals("F")) {
                    isFinished = true;
                    passedKm += 10;
                    raceRoute[carRow][carCol] = ".";
                    raceRoute[carRow][carCol + 1] = "C";
                    break;
                } else {
                    passedKm += 10;
                    raceRoute[carRow][carCol] = ".";
                    raceRoute[carRow][carCol + 1] = "C";
                    carCol++;
                }
            } else if (LEFT.equals(command)) {
                if (raceRoute[carRow][carCol - 1].equals("T")) {
                    passedKm += 30;
                    raceRoute[carRow][carCol - 1] = ".";
                    raceRoute[carRow][carCol] = ".";
                    for (int r = 0; r < raceRoute.length; r++) {
                        for (int c = 0; c < raceRoute[r].length; c++) {
                            if (raceRoute[r][c].equals("T")) {
                                raceRoute[r][c] = "C";
                                carRow = r;
                                carCol = c;
                                break;
                            }
                        }
                    }
                } else if (raceRoute[carRow][carCol - 1].equals("F")) {
                    isFinished = true;
                    passedKm += 10;
                    raceRoute[carRow][carCol] = ".";
                    raceRoute[carRow][carCol - 1] = "C";
                    break;
                } else {
                    passedKm += 10;
                    raceRoute[carRow][carCol] = ".";
                    raceRoute[carRow][carCol - 1] = "C";
                    carCol--;
                }
            }
            command = scanner.nextLine();
        }

        if (isFinished) {
            System.out.printf("Racing car %s finished the stage!\n", racingNumber);
        } else {
            System.out.printf("Racing car %s DNF.\n", racingNumber);
        }

        System.out.printf("Distance covered %d km.\n", passedKm);
        for (int r = 0; r < raceRoute.length; r++) {
            for (int c = 0; c < raceRoute[r].length; c++) {
                System.out.print(raceRoute[r][c]);
            }
            System.out.println();
        }
    }
}



