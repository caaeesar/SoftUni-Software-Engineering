package NestedLoops.moreExercise;

import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());


        for (int first = 2; first <= firstNumber; first++) {

            for (int second = 2; second <= secondNumber; second++) {

                for (int third = 2; third <= thirdNumber; third++) {

                    boolean isPrime = true;
                    boolean firstCondition = first % 2 == 0;

                    // boolean secondCondition = second == 2 || second == 3 || second == 5 || second == 7;

                    for (int divider = 2; divider < second; divider++) {

                        if (second % divider == 0) {
                            isPrime = false;
                        }
                    }

                    boolean thirdCondition = third % 2 == 0;

                    if (firstCondition && isPrime && thirdCondition) {
                        System.out.printf("%d %d %d\n", first, second, third);
                    }
                  /*  if (firstCondition && secondCondition && thirdCondition) {
                        System.out.printf("%d %d %d\n", first, second, third);
                    } */
                }
            }
        }
    }
}
