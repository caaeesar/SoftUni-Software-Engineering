package DataTypesAndVariables.lab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int copyNumber = 0;
        boolean isSpecialNumber = false;
        for (int currentNumber = 1; currentNumber <= n; currentNumber++) {
            copyNumber = currentNumber;

            while (currentNumber > 0) {
                sum += currentNumber % 10;
                currentNumber = currentNumber / 10;
            }
            isSpecialNumber = (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecialNumber) {
            System.out.printf("%d -> True%n", copyNumber);
            } else {
                System.out.printf("%d -> False%n", copyNumber);
            }
            sum = 0;
            currentNumber = copyNumber;
        }
    }
}
