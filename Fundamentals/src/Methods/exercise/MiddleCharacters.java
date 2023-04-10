package Methods.exercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        printMiddleChar(str);
    }

    private static void printMiddleChar(String str) {
        int length = str.length();

        if (length % 2 == 0) {
            char c1 = str.charAt(length / 2 - 1);
            char c2 = str.charAt(length / 2);
            System.out.printf("%c%c",c1,c2);
        } else {
            char c = str.charAt(length / 2);
            System.out.print(c);
        }
    }
}
