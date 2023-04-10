package Methods.lab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int evenSum = getEvenDigit(number);
        int oddSum = getOddDigit(number);
        int result = multiply(evenSum, oddSum);

        System.out.print(result);
    }

    private static int multiply(int evenSum, int oddSum) {
        return evenSum * oddSum;
    }

    static int getOddDigit(int number) {
        int oddSum = 0;

        while (number != 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 != 0) {
                oddSum += lastDigit;
            }
            number /= 10;
        }
        return oddSum;

    }

    static int getEvenDigit(int number) {
        int evenSum = 0;

        while (number != 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 0) {
                evenSum += lastDigit;
            }
            number /= 10;
        }
        return evenSum;
    }
}
