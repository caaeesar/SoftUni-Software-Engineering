package DataTypesAndVariables.lab;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int currentNumber = 1; currentNumber <= n; currentNumber++) {

            int sum = 0;
            int copyNum = currentNumber;

            while (copyNum != 0) {
                int digit = copyNum % 10;
                sum += digit;
                copyNum /= 10;
            }
            switch (sum) {
                case 5:
                case 7:
                case 11:
                    System.out.printf("%d -> True%n", currentNumber);
                    break;
                default:
                    System.out.printf("%d -> False%n", currentNumber);
                    break;
            }
        }
    }
}
