package Methods.exercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int currentNumber = 1; currentNumber <= n; currentNumber++) {

            boolean condition1 = getSumOfDigit(currentNumber);
            boolean condition2 = checkForOddDigit(currentNumber);

            if (condition1 && condition2) {
                System.out.println(currentNumber);
            }
        }
    }

    private static boolean checkForOddDigit(int currentNumber) {
        int countOddDigit = 0;
        while (currentNumber != 0) {
            int lastDigit = currentNumber % 10;

            if (lastDigit % 2 != 0) {
                countOddDigit++;
            }
            currentNumber /= 10;
        }
        if (countOddDigit < 1) {
            return false;
        }
        return true;
    }

    private static boolean getSumOfDigit(int currentNumber) {
        int sum = 0;
        while (currentNumber != 0) {
            int lastDigit = currentNumber % 10;
            sum += lastDigit;
            currentNumber /= 10;
        }
        if (sum % 8 == 0) {
            return true;
        }
        return false;
    }

}
