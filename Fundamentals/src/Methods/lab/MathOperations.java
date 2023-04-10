package Methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        int b = Integer.parseInt(scanner.nextLine());
        double result = 0.00;

        switch (operator) {
            case '/':
                 result = division(a,b);
                break;
            case '*':
                result = multiplication(a,b);
                break;
            case '+':
                result = addition(a,b);
                break;
            case '-':
                result = subtraction(a,b);
                break;
        }
        System.out.print(new DecimalFormat("0.##").format(result));
    }

    private static double subtraction(int a, int b) {
        return a - b;
    }

    private static double addition(int a, int b) {
        return a + b;
    }

    private static double multiplication(int a, int b) {
        return a * b;
    }

    private static double division(int a, int b) {
        return a * 1.00 / b;
    }


}
