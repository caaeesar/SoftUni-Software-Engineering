package Basic.exercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = sumOfFactorial(number);
        if (sum == number) {
            System.out.print("yes");
        } else {
            System.out.print("no");
        }
    }

    private static int sumOfFactorial(int number) {
        int sum = 0;

        while (number != 0) {
            int lastDigit = number % 10;
            int currentFn = 1;

            for (int f = 1; f <= lastDigit; f++) {
                currentFn *= f;
            }
            sum += currentFn;
            number /= 10;
        }
        return sum;
    }
}
