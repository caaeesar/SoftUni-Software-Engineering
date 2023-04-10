package NestedLoops.lab;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int last = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        int combination = 0;
        int number1 = 0;
        int number2 = 0;

        for (int num1 = start; num1 <= last; num1++) {

            for (int num2 = start; num2 <= last; num2++) {

                int result = num1 + num2;
                combination++;

                if (result == magicNumber) {
                    isFound = true;
                    number1 = num1;
                    number2 = num2;
                    break; // прекъсва се само вложения цикъл
                }
            }
            if (isFound) { // прекъсваме и първия цикъл
                break;
            }
        }

        if (isFound) {
            System.out.printf("Combination N:%d (%d + %d = %d)", combination, number1, number2, magicNumber);
        } else {
            System.out.printf("%d combinations - neither equals %d", combination, magicNumber);
        }
    }
}
