package TextProcessing.lab;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         *  StringBuilder sb = new StringBuilder();
         *         String input = scanner.nextLine();
         *         while (!"end".equals(input)) {
         *
         *             System.out.printf("%s = %s\n", input, sb.append(input).reverse());
         *             input = scanner.nextLine();
         *             sb = new StringBuilder();
         *         }
         */

        String str = scanner.nextLine();
        while (!"end".equals(str)) {

            String reversedStr = reverseString(str);
            System.out.printf("%s = %s%n", str, reversedStr);
            str = scanner.nextLine();
        }
    }

    static String reverseString(String str) {
        StringBuilder reversedStr = new StringBuilder();
        for (int index = str.length() - 1; index >= 0; index--) {
            reversedStr.append(str.charAt(index));
        }
        return reversedStr.toString();
    }
}
