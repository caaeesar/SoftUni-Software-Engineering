package Methods.lab;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int result = 0;
        switch (operation) {
            case "add":
                result = addNumbers(a, b);
                break;
            case "multiply":
                result = multiplication(a, b);
                break;
            case "subtract":
                result = subtraction(a, b);
                break;
            case "divide":
                result = division(a, b);
                break;
        }
        System.out.print(result);
    }

    private static int division(int a, int b) {
        return a / b;
    }

    private static int subtraction(int a, int b) {
        return a - b;
    }

    private static int multiplication(int a, int b) {
        return a * b;
    }

    private static int addNumbers(int a, int b) {
        return a + b;
    }
}
