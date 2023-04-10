package MultidimensionalArrays.exercises;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] parkingSize = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = parkingSize[0];
        int cols = parkingSize[1];

        boolean[][] isOccupied = new boolean[rows][cols];
        // заето -> true
        // сбободно -> false
        for (int row = 0; row < isOccupied.length; row++) {
            // първата колона е за вход на колите
            isOccupied[row][0] = true;
        }

        String input = scanner.nextLine();
        while (!"stop".equals(input)) {

            int entryRow = Integer.parseInt(input.split("\\s+")[0]);
            int targetRow = Integer.parseInt(input.split("\\s+")[1]);
            int targetCol = Integer.parseInt(input.split("\\s+")[2]);
            boolean isFoundFreePlace = false;

            int distance = 1;
            distance += Math.abs(targetRow - entryRow);

            if (!isOccupied[targetRow][targetCol]) { // ако желаното място е свободно
                distance += targetCol;
                isOccupied[targetRow][targetCol] = true;
                isFoundFreePlace = true;
            } else { // ако желаното място е заето

                for (int currentCol = 1; currentCol < isOccupied[targetRow].length; currentCol++) {
                    // проверяваме наляво първо -> най-близо до входа
                    if (targetCol - currentCol > 0 && !isOccupied[targetRow][targetCol - currentCol]) {
                        isOccupied[targetRow][targetCol - currentCol] = true;
                        isFoundFreePlace = true;
                        distance += targetCol - currentCol;
                        break;
                    }
                    // проверяваме надясно първо
                    if (targetCol + currentCol < isOccupied[targetRow].length && !isOccupied[targetRow][targetCol + currentCol]) {
                        isOccupied[targetRow][targetCol + currentCol] = true;
                        isFoundFreePlace = true;
                        distance += targetCol + currentCol;
                        break;
                    }
                }
            }

            if (isFoundFreePlace) {
                System.out.println(distance);
            } else {
                System.out.printf("Row %d full\n", targetRow);
            }

            input = scanner.nextLine();
        }
    }
}
