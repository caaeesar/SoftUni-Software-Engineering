package StacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        Deque<Character> openBrackets = new ArrayDeque<>();

        boolean isBalanced = true;

        for (int index = 0; index < expression.length(); index++) {

            char currentSymbol = expression.charAt(index);

            switch (currentSymbol) {
                case '(':
                    openBrackets.push(')');
                    break;
                case '{':
                    openBrackets.push('}');
                    break;
                case '[':
                    openBrackets.push(']');
                    break;
                case ')':
                case '}':
                case ']':
                    if (openBrackets.isEmpty() || openBrackets.pop() != currentSymbol) {
                        isBalanced = false;
                    }
                    break;
            }
        }
        if (isBalanced && openBrackets.isEmpty()) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}
