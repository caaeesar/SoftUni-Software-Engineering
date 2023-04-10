package NestedLoops.moreExercise;

import java.util.Scanner;

public class SecretDoorsLock {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int firstLimit = Integer.parseInt(scanner.nextLine());
        int secondLimit = Integer.parseInt(scanner.nextLine());
        int thirdLimit = Integer.parseInt(scanner.nextLine());

    /*   //   ЧРЕЗ АЛГОРИТЪМ ЗА ПРОСТИ ЧИСЛА
        for (int firstDigit = 1; firstDigit <= firstLimit; firstDigit++) {

            for (int secondDigit = 2; secondDigit <= secondLimit; secondDigit++) {

                for (int thirdDigit = 1; thirdDigit <= thirdLimit; thirdDigit++) {
                    boolean isPrime = true;


                    for (int divider = 2; divider < secondDigit; divider++) {

                        if (secondDigit % divider == 0) {
                            isPrime = false;
                        }
                    }
                    boolean areEven = firstDigit % 2 == 0 && thirdDigit % 2 == 0;
                    if (isPrime && areEven) {
                        System.out.printf("%d %d %d\n", firstDigit, secondDigit, thirdDigit);
                    }
                }
            }
        } */

        // ЧРЕЗ ХАРДКОДВАНЕ

       for (int firstDigit = 1; firstDigit <= firstLimit; firstDigit++) {

            for (int secondDigit = 1; secondDigit <= secondLimit; secondDigit++) {

                for (int thirdDigit = 1; thirdDigit <= thirdLimit; thirdDigit++) {

                    boolean areEven = firstDigit % 2 == 0 && thirdDigit % 2 == 0;
                    boolean isPrime = ((secondDigit == 2) || (secondDigit == 3) || (secondDigit == 5) || (secondDigit == 7));

                    if (areEven && isPrime) {
                        System.out.printf("%d %d %d\n", firstDigit,secondDigit,thirdDigit);
                    }
                }
            }
        }
    }
}

