package StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        Deque<Integer> indexesOfOpenBrackets = new ArrayDeque<>();

        for (int index = 0; index < expression.length(); index++) {

            char symbol = expression.charAt(index);

            if (symbol == '(') {
                indexesOfOpenBrackets.push(index);
            } else if (symbol == ')') {
                int startIndex = indexesOfOpenBrackets.pop();
                String subEx = expression.substring(startIndex, index + 1);
                System.out.println(subEx);
            }
        }
    }
}
