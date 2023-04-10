package IntroToJava;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String reversNumber = String.join("",reversString(convertIntToString(number)));

       System.out.println(reversNumber);
    }

    static String convertIntToString(int n) {
        String number = String.valueOf(n);
        return number;
    }

    static String[] reversString(String str) {
        String[] digits = new String[str.length()];
        int index = 0;
        int number = Integer.parseInt(str);
        while (number != 0) {
            int digit = number % 10;
            digits[index] = String.valueOf(digit);
            number /= 10;
            index++;
        }
        return digits;
    }
}
