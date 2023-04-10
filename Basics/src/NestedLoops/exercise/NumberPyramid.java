package NestedLoops.exercise;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int currentNumber = 1;
        boolean isBigger = false;

        for (int rows = 1; rows <= input; rows++) {

            for (int cols = 1; cols <= rows; cols++) { // броя на реда отговаря на броя на колоните;

                System.out.printf("%d ", currentNumber);
                currentNumber++;

                if (currentNumber > input) {
                    isBigger = true;
                    break; // прекъсваме вложения цикъл
                }
            }
            if (isBigger) {
                break;
            }
            System.out.println();
        }
    }
}
