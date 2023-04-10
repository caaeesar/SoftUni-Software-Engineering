package Lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        String command = scanner.nextLine();
        int number;
        int index;
        int count;

        while (!"End".equals(command)) {
            String[] operations = command.split(" ");

            switch (operations[0]) {

                case "Add":
                    number = Integer.parseInt(operations[1]);
                    addElement(numbers, number);
                    break;
                case "Insert":
                    number = Integer.parseInt(operations[1]);
                    index = Integer.parseInt(operations[2]);
                    if (index >= numbers.size() || index < 0) {
                        System.out.println("Invalid index");
                    } else {
                        insertElement(numbers, number, index);
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(operations[1]);
                    if (index >= numbers.size() || index < 0) {
                        System.out.println("Invalid index");
                    } else {
                        removeElement(numbers, index);
                    }
                    break;
                case "Shift":

                    switch (operations[1]) {
                        case "left":
                            count = Integer.parseInt(operations[2]);
                            shiftLeftFirstElement(numbers, count);
                            break;
                        case "right":
                            count = Integer.parseInt(operations[2]);
                            shiftRightLastElement(numbers, count);
                            break;
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.print(String.join(" ", numbers));

    }

    private static void shiftRightLastElement(List<String> numbers, int count) {

        while (count != 0) {
            String currentLastElement = numbers.get(numbers.size() - 1);
            numbers.remove(currentLastElement);
            numbers.add(0, currentLastElement);
            count--;
        }
    }

    private static void shiftLeftFirstElement(List<String> numbers, int count) {
        int index = 0;
        while (count != 0) {
            String currentFirstElement = numbers.get(index);
            numbers.add(currentFirstElement);
            numbers.remove(currentFirstElement);
            count--;
        }
    }

    private static void removeElement(List<String> numbers, int index) {
        numbers.remove(index);
    }

    private static void insertElement(List<String> numbers, int number, int index) {
        numbers.add(index, String.valueOf(number));
    }

    private static void addElement(List<String> numbers, int number) {
        numbers.add(String.valueOf(number));
    }
}
