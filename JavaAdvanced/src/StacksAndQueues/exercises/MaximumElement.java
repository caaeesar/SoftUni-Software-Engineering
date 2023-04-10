package StacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int allCommands = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < allCommands; i++) {

            int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            switch (input[0]) {
                case 1:
                    int element = input[1];
                    stack.push(element);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    int maxElement = getBiggestElement(stack);
                    System.out.println(maxElement);
                    break;
            }
        }
    }

    private static int getBiggestElement(Deque<Integer> stack) {
        int maxElement = Integer.MIN_VALUE;
        for (int currentNum : stack) {
            if (currentNum > maxElement) {
                maxElement = currentNum;
            }
        }
        return maxElement;
    }
}
