package NestedLoops.moreExercise;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int combination = 0;
        boolean isFind = false;

        for (int firstNumber = start; firstNumber <= end; firstNumber++) {

            for (int secondNumber = start; secondNumber <= end; secondNumber++) {

                combination++;

                if (firstNumber + secondNumber == magicNumber) {
                    isFind = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", combination, firstNumber, secondNumber, magicNumber);
                    break;
                }
            }
            if (isFind) {
                break;
            }
        }
        if (!isFind) {
            System.out.printf("%d combinations - neither equals %d", combination, magicNumber);

        }
    }
}
