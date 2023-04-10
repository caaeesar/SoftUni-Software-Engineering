package DataTypesAndVariables.moreExercise;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int currentLine = 1; currentLine <= lines; currentLine++) {

            String[] array = scanner.nextLine().split(" ");
            long leftNum = Long.parseLong(array[0]);
            long rightNum = Long.parseLong(array[1]);

            if (leftNum > rightNum) {
                int sum = summingAllDigit(Math.abs(leftNum));
                System.out.printf("%d%n", sum);
            } else {
                int sum = summingAllDigit(Math.abs(rightNum));
                System.out.printf("%d%n", sum);
            }
        }
    }

    private static int summingAllDigit(long greaterNumber) {
        int sum = 0;

        while (greaterNumber > 0) {
            long lastDigit = greaterNumber % 10;
            sum += lastDigit;
            greaterNumber /= 10;
        }
        return sum;
    }
}
