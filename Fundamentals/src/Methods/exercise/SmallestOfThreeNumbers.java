package Methods.exercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int smallestNumber = getSmallestNumber(a, b, c);
        System.out.print(smallestNumber);
    }

    static int getSmallestNumber(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        }
        return c;
    }
}
