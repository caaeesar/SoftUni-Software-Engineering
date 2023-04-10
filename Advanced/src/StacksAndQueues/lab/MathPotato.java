package StacksAndQueues.lab;

import java.util.*;
import java.util.stream.Collectors;

public class MathPotato {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        PriorityQueue<String> children = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(PriorityQueue::new));

        int steps = Integer.parseInt(scanner.nextLine());
        int cycle = 1;

        while (children.size() > 1) {

            for (int currentStep = 1; currentStep < steps; currentStep++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + children.peek());
            } else {
                System.out.println("Removed " + children.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + children.poll());
    }

    private static boolean isPrime(int round) {
        if (round == 1) {
            return false;
        }
        for (int i = 2; i < round; i++) {
            if (round % i == 0) {
                return false;
            }
        }
        return true;

    }
}
