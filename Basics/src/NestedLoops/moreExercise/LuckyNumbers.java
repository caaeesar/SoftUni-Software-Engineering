package NestedLoops.moreExercise;

import java.util.Scanner;

public class LuckyNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int firstDigit = 1; firstDigit <= 9; firstDigit++) {


            for (int secondDigit = 1; secondDigit <= 9; secondDigit++) {

                for (int thirdDigit = 1; thirdDigit <= 9; thirdDigit ++) {

                    for (int forthDigit = 1; forthDigit <= 9; forthDigit++) {

                      int  sumFirstSecond = firstDigit + secondDigit;
                      int  sumThirdForth = thirdDigit + forthDigit;

                        boolean firstCondition = sumFirstSecond == sumThirdForth;
                        boolean secondCondition = input % sumFirstSecond == 0;

                        if (firstCondition && secondCondition) {
                            System.out.printf("%d%d%d%d ", firstDigit,secondDigit, thirdDigit, forthDigit);
                        }
                    }
                }
            }
        }
    }
}
