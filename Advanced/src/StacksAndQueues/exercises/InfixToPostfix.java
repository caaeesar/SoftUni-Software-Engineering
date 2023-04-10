package StacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // ОБРАТЕН ПОЛСКИ ЗАПИС - по-ефективен за компютърната памет
        // приоритет на операциите =>  ( ) ; * / ; + -

        // 5 + ((1 + 2) * 4) – 3

        String infixExpression = scanner.nextLine();
        infixExpression = infixExpression.replaceAll("\\s+", "");
        String postfixExpression = "";

        Deque<Character> stack = new ArrayDeque<>();

        for (int index = 0; index < infixExpression.length(); index++) {
            char symbol = infixExpression.charAt(index);

            if (Character.isDigit(symbol) || Character.isLetter(symbol)) { // ако е цифра или буква добавяме към изходния израз
                postfixExpression += symbol;

            } else if (symbol == '(') { // ако е отваряща скоба я добавяме в стека
                stack.push(symbol);

            } else if (symbol == ')') { // ако е затваряща се скоба
                // докато в стека има оператори и последния оператор не е скоба
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixExpression += stack.peek(); // добавяме оператора в изходния израз
                    stack.pop(); // премахваме го
                }
                stack.pop(); // премахваме скобата

            } else { // ако символа е някой математически оператор
                // докато стека не е празен и приоритета на текущия символ е по-малък от последния в стека
                while (!stack.isEmpty() && precedence(symbol) <= precedence(stack.peek())) {
                    postfixExpression += stack.pop(); // към изходния израз добавяме последния оператор
                }
                stack.push(symbol); //
            }
        }

        while (!stack.isEmpty()) {
            postfixExpression += stack.pop();
        }
        for (int i = 0; i < postfixExpression.length(); i++) {
            System.out.print(postfixExpression.charAt(i) + " ");
        }
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':         // lowest precedence
            case '-':
                return 1;
            case '*':
            case '/':         // highest precedence
                return 2;
        }
        return -1; // при скоби
    }
}
