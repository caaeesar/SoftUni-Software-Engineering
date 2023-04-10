package Exams.MidRetake.Exam_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MemoryGame {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequenceOfElements = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        int moves = 0;

        String command = scanner.nextLine();
        while (!"end".equals(command)) {

            moves++;
            String[] parts = command.split(" ");
            int index1 = Integer.parseInt(parts[0]);
            int index2 = Integer.parseInt(parts[1]);

            boolean areValidIndexes = checkedIndexes(sequenceOfElements, index1, index2);
            if (!areValidIndexes) {
                addTwoElementsInMiddle(sequenceOfElements, moves);
                System.out.println("Invalid input! Adding additional elements to the board");
            } else {
                boolean isEqualElements = checkForEqualElements(sequenceOfElements, index1, index2);
                if (isEqualElements) {
                    removeElements(sequenceOfElements, index1, index2);
                } else {
                    System.out.println("Try again!");
                }
            }
            if (sequenceOfElements.isEmpty()) {
                System.out.printf("You have won in %d turns!", moves);
                break;
            }
            command = scanner.nextLine();
        }
        if ("end".equals(command) && !sequenceOfElements.isEmpty()) {
            System.out.println("Sorry you lose :(");
            sequenceOfElements.forEach(e -> System.out.print(e + " "));
        }
    }

    private static void removeElements(List<String> sequenceOfElements, int index1, int index2) {
        String firstElement = sequenceOfElements.get(index1);
        String secondElement = sequenceOfElements.get(index2);
        sequenceOfElements.remove(firstElement);
        sequenceOfElements.remove(secondElement);
        System.out.printf("Congrats! You have found matching elements - %s!\n", firstElement);
    }

    private static boolean checkForEqualElements(List<String> sequenceOfElements, int index1, int index2) {
        String firstElement = sequenceOfElements.get(index1);
        String secondElement = sequenceOfElements.get(index2);
        return firstElement.equals(secondElement);
    }

    private static void addTwoElementsInMiddle(List<String> sequenceOfElements, int moves) {
        int indexToAdd = sequenceOfElements.size() / 2;
        String elementToAdd = String.valueOf(moves);
        sequenceOfElements.add(indexToAdd, "-" + elementToAdd + "a");
        sequenceOfElements.add(indexToAdd + 1, "-" + elementToAdd + "a");
    }

    private static boolean checkedIndexes(List<String> sequenceOfElements, int index1, int index2) {
        if ((index1 >= sequenceOfElements.size() || index1 < 0) // невалиден 1-ви индекс
                || (index2 >= sequenceOfElements.size() || index2 < 0) // невалиден 2-ри индекс
                || (index1 == index2)) { // еднакви индекси
            return false;
        }
        return true;
    }
}
