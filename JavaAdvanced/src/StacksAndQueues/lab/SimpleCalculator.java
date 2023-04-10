package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SimpleCalculator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> expression = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (expression.size() > 1) {

            int firstNumber = Integer.parseInt(expression.pop());
            String sign = expression.pop();
            int secondNumber = Integer.parseInt(expression.pop());

            int currentSum = 0;
            switch (sign) {
                case "+":
                    currentSum = firstNumber + secondNumber;
                    break;
                case "-":
                    currentSum = firstNumber - secondNumber;
                    break;
            }
            expression.push(String.valueOf(currentSum));
        }
        System.out.print(expression.pop());
    }
}
