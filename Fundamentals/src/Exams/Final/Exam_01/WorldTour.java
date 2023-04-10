package Exams.Final.Exam_01;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder allStops = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!"Travel".equals(input)) {

            String[] parts = input.split(":");
            String command = parts[0];
            if ("Add Stop".equals(command)) {
                int index = Integer.parseInt(parts[1]);
                String stop = parts[2];
                boolean isValidIndex = validationIndex(index, allStops);
                if (isValidIndex) {
                    addingStop(stop, index, allStops);
                }
            } else if ("Remove Stop".equals(command)) {
                int startIndex = Integer.parseInt(parts[1]);
                int endIndex = Integer.parseInt(parts[2]);
                boolean areValidIndexes = validationIndex(startIndex, endIndex, allStops);
                if (areValidIndexes) {
                    removingStop(startIndex, endIndex + 1, allStops);
                }
            } else if ("Switch".equals(command)) {
                String oldString = parts[1];
                String newString = parts[2];
                int existStrIndex = allStops.indexOf(oldString);

                if (existStrIndex != -1 && !newString.equals(oldString)) {
                       allStops = new StringBuilder(allStops.toString().replace(oldString, newString));
                      //  allStops.replace(existStrIndex, existStrIndex + oldString.length(), newString);
                      //  existStrIndex = allStops.indexOf(oldString);
                       /* if (!allStops.toString().contains(oldString)) {
                            break;
                        }*/

                }
            }
            System.out.println(allStops);
            input = scanner.nextLine();
        }
        System.out.print("Ready for world tour! Planned stops: " + allStops);
    }

    private static void removingStop(int startIndex, int endIndex, StringBuilder allStops) {
        allStops.delete(startIndex, endIndex);
    }

    private static void addingStop(String stop, int index, StringBuilder allStops) {
        allStops.insert(index, stop);
    }

    private static boolean validationIndex(int index, StringBuilder allStops) {
        return index >= 0 && index < allStops.length();
    }

    private static boolean validationIndex(int index1, int index2, StringBuilder allStops) {
        return index1 >= 0 &&
                index2 >= 0 &&
                index1 < allStops.length()
                && index2 < allStops.length();
    }
}
