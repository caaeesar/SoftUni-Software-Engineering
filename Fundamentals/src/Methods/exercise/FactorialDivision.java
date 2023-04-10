package Methods.exercise;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        double f1 = factorial(a);
        double f2 = factorial(b);
        double result = division(f1, f2);
        System.out.printf("%.2f", result);
    }

    private static double division(double f1, double f2) {
        return f1 / f2;
    }

    private static double factorial(int x) {
        double f = 1;
        for (int i = 2; i <= x; i++) {
            f *= i;
        }
        return f;
    }
}
