package Exams.MidRetake.Exam_02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetsValuesList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        int index;
        while (!"End".equals(input)) {

            String[] parts = input.split(" ");
            String command = parts[0];
            switch (command) {
                case "Shoot":
                    index = Integer.parseInt(parts[1]);
                    int power = Integer.parseInt(parts[2]);
                    shootingTarget(targetsValuesList, index, power);
                    break;
                case "Add":
                    index = Integer.parseInt(parts[1]);
                    int value = Integer.parseInt(parts[2]);
                    insertTarget(targetsValuesList, index, value);
                    break;
                case "Strike":
                    index = Integer.parseInt(parts[1]);
                    int radius = Integer.parseInt(parts[2]);
                    removeTarget(targetsValuesList, index, radius);
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < targetsValuesList.size(); i++) {
            if (i == targetsValuesList.size() - 1) {
                System.out.print(targetsValuesList.get(i));
            } else {
                System.out.print(targetsValuesList.get(i) + "|");
            }
        }
    }

    private static void removeTarget(List<Integer> targetsValuesList, int index, int radius) {
        boolean isValidIndex = validateIndex(index, targetsValuesList);
        boolean isValidRadius = validateRadius(radius, index, targetsValuesList);
        if (isValidIndex && isValidRadius) {
            int targetIndex = index - radius;
            int countRemoved = (radius * 2) + 1;
            int count = 0;
            while (count < countRemoved) {
                targetsValuesList.remove(targetIndex);
                count++;
            }
        } else {
            System.out.println("Strike missed!");
        }
    }

    private static boolean validateRadius(int radius, int index, List<Integer> targetsValuesList) {
        return (index - radius >= 0) && (index + radius < targetsValuesList.size());
    }

    private static void insertTarget(List<Integer> targetsValuesList, int index, int value) {
        boolean isValidIndex = validateIndex(index, targetsValuesList);
        if (isValidIndex) {
            targetsValuesList.add(index, value);
        } else {
            System.out.println("Invalid placement!");
        }
    }

    private static boolean validateIndex(int index, List<Integer> targetsValuesList) {
        return index >= 0 && index < targetsValuesList.size();
    }

    private static void shootingTarget(List<Integer> targetsValuesList, int index, int power) {
        boolean isValidIndex = validateIndex(index, targetsValuesList);
        if (isValidIndex) {
            int currentValueTarget = targetsValuesList.get(index);
            currentValueTarget -= power;
            targetsValuesList.set(index, currentValueTarget);
            if (currentValueTarget <= 0) {
                targetsValuesList.remove(index);
            }
        }
    }
}
