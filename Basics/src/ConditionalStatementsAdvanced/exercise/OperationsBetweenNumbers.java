package ConditionalStatementsAdvanced.exercise;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        char symbol = scanner.nextLine().charAt(0);
        double result = 0.00;
        String oddOrEven = "";

        switch (symbol) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = (number1 / (number2 * 1.00));
                if (number2 == 0) {
                    System.out.printf("Cannot divide %d by zero", number1);
                } else {
                    System.out.printf("%d %c %d = %.2f", number1, symbol, number2, result);
                }
                break;
            case '%':
                if (number2 == 0) {
                    System.out.printf("Cannot divide %d by zero", number1);
                } else {
                    result = number1 % number2;
                    System.out.printf("%d %c %d = %.0f", number1, symbol, number2, result);
                }
                break;
        }

        switch (symbol) {
            case '+':
            case '-':
            case '*':
                if (result % 2 == 0) {
                    oddOrEven = "even";
                } else {
                    oddOrEven = "odd";
                }
                System.out.printf("%d %c %d = %.0f - %s", number1, symbol, number2, result, oddOrEven);
                break;
        }
    }
}
