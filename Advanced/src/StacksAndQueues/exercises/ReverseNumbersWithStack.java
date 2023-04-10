package StacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int number : numbers) {
            stack.push(number);
        }

        for (int number : stack) {
            System.out.print(number + " ");
        }
    }
}
