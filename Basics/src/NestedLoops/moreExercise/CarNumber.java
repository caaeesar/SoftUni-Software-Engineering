package NestedLoops.moreExercise;

import java.util.Scanner;

public class CarNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int begin = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        for (int firstDigit = begin; firstDigit <= end; firstDigit++) {

            for (int secondDigit = begin; secondDigit <= end; secondDigit++) {

                for (int thirdDigit = begin; thirdDigit <= end; thirdDigit++) {

                    for (int forthDigit = begin; forthDigit <= end; forthDigit++) {

                        int sumSecondThird = secondDigit + thirdDigit;

                        boolean firstCondition = firstDigit > forthDigit;
                        boolean secondCondition = sumSecondThird % 2 == 0;
                        boolean thirdCondition = (firstDigit % 2 == 0 && forthDigit % 2 != 0) || (firstDigit % 2 != 0 && forthDigit % 2 == 0);

                        if (firstCondition && secondCondition && thirdCondition) {
                            System.out.printf("%d%d%d%d ", firstDigit, secondDigit, thirdDigit, forthDigit);
                        }
                    }
                }
            }
        }
    }
}
