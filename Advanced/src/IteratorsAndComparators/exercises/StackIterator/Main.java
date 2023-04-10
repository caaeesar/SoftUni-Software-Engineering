package IteratorsAndComparators.exercises.StackIterator;

import IteratorsAndComparators.exercises.StackIterator.MyStack;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static final String END = "END";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().substring(5);

        List<Integer> elements = Arrays.stream(input.trim().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        MyStack<Integer> stack = new MyStack<>();
        stack.push(elements);

        String command = scanner.nextLine();
        while (!END.equals(command)) {

            if (command.contains("Push")) {
                elements = Arrays.stream(command.substring(5).trim().split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                stack.push(elements);
            } else if (command.contains("Pop")) {
                try {
                    stack.pop();
                } catch (IndexOutOfBoundsException | NoSuchElementException | IllegalArgumentException e) {
                    System.out.println("No elements");
                    break;
                }
            }
            command = scanner.nextLine();
        }
        for (Integer e : stack) {
            System.out.println(e);
        }
    }
}
