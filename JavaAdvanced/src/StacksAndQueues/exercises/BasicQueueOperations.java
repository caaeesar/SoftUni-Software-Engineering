package StacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sizeOfQueue = input[0];
        int countOfPollElements = input[1];
        int searchNumber = input[2];

        Deque<Integer> queue = new ArrayDeque<>(sizeOfQueue);
        for (int i = 0; i < sizeOfQueue; i++) {
            int currentNumber = scanner.nextInt();
            queue.offer(currentNumber);
        }

        for (int i = 0; i < countOfPollElements; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(searchNumber)) {
            System.out.println("true");
        } else {
            int smallestElement = getSmallestElement(queue);
            System.out.println(smallestElement);
        }
    }

    private static int getSmallestElement(Deque<Integer> queue) {
        int minElement = Integer.MAX_VALUE;
        for (int currentNum : queue) {
            if (currentNum < minElement) {
                minElement = currentNum;
            }
        }
        return minElement;
    }
}
