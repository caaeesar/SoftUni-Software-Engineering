package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> children = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int steps = Integer.parseInt(scanner.nextLine());

        while (children.size() > 1){

            for (int currentStep = 1; currentStep < steps; currentStep++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }
            System.out.println("Removed " + children.poll());
        }
        System.out.println("Last is " + children.poll());
    }
}
