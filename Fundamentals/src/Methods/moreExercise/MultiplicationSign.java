package Methods.moreExercise;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        boolean isNegative = checkSign(a, b, c);
        boolean isPositive = checkNumbers(a, b, c);
        boolean isZero = checkZero(a, b, c);

        if (isNegative) {
            System.out.print("negative");
        } else if (isPositive) {
            System.out.print("positive");
        } else if (isZero) {
            System.out.print("zero");
        }
    }

    private static boolean checkNumbers(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0;
    }

    private static boolean checkZero(int a, int b, int c) {
        return a == 0 || b == 0 || c == 0;
    }

    private static boolean checkSign(int a, int b, int c) {
        int countNegative = 0;
        if (a < 0) {
            countNegative++;
        }
        if (b < 0) {
            countNegative++;
        }
        if (c < 0) {
            countNegative++;
        }
        if (countNegative == 2) {
            System.out.print("positive");
            return false;
        } else { return countNegative == 3 || countNegative == 1;}
    }
}
