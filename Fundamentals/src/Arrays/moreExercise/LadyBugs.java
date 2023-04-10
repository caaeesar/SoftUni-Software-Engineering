package Arrays.moreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadyBugs {

    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        int sizeOfField = Integer.parseInt(scanner.nextLine());
        List<Integer> indexesOfBugs = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int[] field = new int[sizeOfField];
        putBugInField(field, indexesOfBugs);

        String line = scanner.nextLine();
        while (!"end".equals(line)) {
            String[] parts = line.split(" ");
            int flyLength = Integer.parseInt(parts[2]);
            int ladybugIndex = Integer.parseInt(parts[0]);
            String direction = parts[1];
            switch (direction) {
                case "right":
                    moveRightBug(field, ladybugIndex, flyLength);
                    break;
                case "left":
                    moveLeftBug(field, ladybugIndex, flyLength);
                    break;
            }
            line = scanner.nextLine();
        }
        printAllCells(field);
    }

    private static void printAllCells(int[] field) {
        for (int cell : field) {
            System.out.print(cell + " ");
        }
    }

    public static void putBugInField(int[] field, List<Integer> indexesOfBugs) {
        // check if indexes are valid
        for (int index = 0; index < indexesOfBugs.size(); index++) {
            if (indexesOfBugs.get(index) >= 0 && indexesOfBugs.get(index) < field.length) {
                field[indexesOfBugs.get(index)] = 1;
            }
        }
    }

    public static void moveRightBug(int[] field, int ladybugIndex, int flyLength) {
        //If you are given a ladybug index that does not have a ladybug there, nothing happens.
        //If you are given a ladybug index that is outside the field, nothing happens.
        if (ladybugIndex < 0 || ladybugIndex >= field.length || field[ladybugIndex] == 0) {
            return;
        }
        field[ladybugIndex] = 0; //
        int landingCell = ladybugIndex + flyLength; // nextPosition
        while (landingCell < field.length) { // check if flyLength is in range of field
            if (field[landingCell] == 0) {
                field[landingCell] = 1;
                break;
            } else { //lands on a fellow ladybug continues to fly in the same direction by the same fly length
                landingCell += flyLength;
            }
        }
    }

    public static void moveLeftBug(int[] field, int ladybugIndex, int flyLength) {
        if (ladybugIndex < 0 || ladybugIndex >= field.length || field[ladybugIndex] == 0) {
            return;
        }
        field[ladybugIndex] = 0;
        int landingCell = ladybugIndex - flyLength;
        field[ladybugIndex] = 0;
        while (landingCell >= 0) {
            if (field[landingCell] == 0) {
                field[landingCell] = 1;
                break;
            } else {
                landingCell -= flyLength;
            }
        }
    }
}

