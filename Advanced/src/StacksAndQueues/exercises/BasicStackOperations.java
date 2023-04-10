package StacksAndQueues.exercises;

import java.util.*;

public class BasicStackOperations {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] inputLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sizeOfStack = inputLine[0];
        int countPopElements = inputLine[1];
        int searchNumber = inputLine[2];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < sizeOfStack; i++) {
            int currentNumber = scanner.nextInt();
            stack.push(currentNumber);
        }

        for (int i = 0; i < countPopElements; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(searchNumber)) {
            System.out.println("true");
        } else {
            int smallestElement = getSmallestElement(stack);
            System.out.println(smallestElement);
        }
    }

    private static int getSmallestElement(Deque<Integer> stack) {
        int minElement = Integer.MAX_VALUE;
        for (int number : stack) {

            if (number < minElement) {
                minElement = number;
            }
        }
        return minElement;
    }
}
