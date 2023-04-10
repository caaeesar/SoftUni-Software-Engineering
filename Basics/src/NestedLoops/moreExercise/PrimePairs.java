package NestedLoops.moreExercise;

import java.util.Scanner;

public class PrimePairs {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int startFirstPair = Integer.parseInt(scanner.nextLine());
        int startSecondPair = Integer.parseInt(scanner.nextLine());
        int firstDifference = Integer.parseInt(scanner.nextLine());
        int secondDifference = Integer.parseInt(scanner.nextLine());

        for (int firstPair = startFirstPair; firstPair <= (startFirstPair + firstDifference); firstPair++) {

            for (int secondPair = startSecondPair; secondPair <= (startSecondPair + secondDifference); secondPair++) {

                boolean isFirstPrime = true;
                boolean isSecondPrime = true;

                for (int divider = 2; divider < firstPair; divider++) {

                    if (firstPair % divider == 0) {
                        isFirstPrime = false;
                        break;
                    }
                }
                for (int divider = 2; divider < secondPair; divider++) {

                    if (secondPair % divider == 0) {
                        isSecondPrime = false;
                        break;
                    }
                }
                if (isFirstPrime && isSecondPrime) {
                    System.out.printf("%d%d\n", firstPair, secondPair);
                }
            }
        }
    }
}
