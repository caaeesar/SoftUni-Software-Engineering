package Methods.exercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int sum = addition(a, b);
        int diff = subtraction(sum, c);
        System.out.print(diff);
    }

    private static int addition(int a, int b) {
        return a + b;
    }

    static int subtraction(int sum, int c) {
        return sum - c;
    }
}
