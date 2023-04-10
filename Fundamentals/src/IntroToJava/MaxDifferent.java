package IntroToJava;

import java.util.Scanner;

public class MaxDifferent {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // 7 1 13 2 33:
        // 7 - 1; 7 - 13; 7 - 2; 7 - 33;
        // 1 - 13; 1 -2; 1 - 33;
        // 13 - 2; 12 - 33;
        // 2 - 33;

        String[] line = scanner.nextLine().split(" ");

        int[] numbers = new int[line.length];

        for (int index = 0; index < numbers.length; index++) {

            numbers[index] = Integer.parseInt(line[index]);
        }

        int maxDiff = Integer.MAX_VALUE;

        for (int minuend = 0; minuend < numbers.length - 1; minuend++) {

            for (int subtrahend = minuend + 1; subtrahend < numbers.length; subtrahend++) {

                int currentDiff = Math.abs(numbers[minuend] - numbers[subtrahend]);

                if (currentDiff < maxDiff) {
                    maxDiff = currentDiff;
                }
            }
        }
        System.out.print(maxDiff);
    }
}
