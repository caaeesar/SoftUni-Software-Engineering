package JavaBook.DrawingOnConsole;

import java.util.Scanner;

public class Axe {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int cols = n * 5;
        int countLeftDashes = n * 3;
        int countRightDashes = cols - countLeftDashes - 2;
        int countMidDashes = 0;

        // първа част:
        for (int row = 1; row <= n; row++) {

            String leftDashes = repeatString("-", countLeftDashes);
            String midDashes = repeatString("-", countMidDashes);
            String rightDashes = repeatString("-", countRightDashes);
            System.out.printf("%s*%s*%s%n", leftDashes, midDashes, rightDashes);
            countMidDashes++;
            countRightDashes--;
        }
        countMidDashes--;
        countRightDashes++;
        // средна част:
        for (int row = 1; row <= (n / 2); row++) {
            String leftStars = repeatString("*", n * 3);
            String midDashes = repeatString("-", countMidDashes);
            String rightDashes = repeatString("-", countRightDashes);
            System.out.printf("%s*%s*%s%n", leftStars, midDashes, rightDashes);
        }
        // последна част:
        for (int row = 1; row <= (n / 2) - 1; row++) {

            String leftDashes = repeatString("-", countLeftDashes);
            String midDashes = repeatString("-", countMidDashes);
            String rightDashes = repeatString("-", countRightDashes);
            System.out.printf("%s*%s*%s%n", leftDashes, midDashes, rightDashes);
            countMidDashes += 2;
            countRightDashes--;
            countLeftDashes--;
        }
        // последен ред:
        String leftDashes = repeatString("-", countLeftDashes);
        String midStars = repeatString("*", countMidDashes);
        String rightDashes = repeatString("-", countRightDashes);
        System.out.printf("%s*%s*%s", leftDashes, midStars, rightDashes);
    }

    static String repeatString(String str, int count) {
        StringBuilder text = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            text.append(str);
        }
        return text.toString();
    }
}
