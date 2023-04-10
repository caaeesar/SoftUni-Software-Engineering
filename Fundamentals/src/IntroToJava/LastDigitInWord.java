package IntroToJava;

import java.util.Scanner;

public class LastDigitInWord {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
       String result = convertDigitToString(getLastDigit(number));
       System.out.println(result);

    }

    static int getLastDigit(int number) {
        return number % 10;
    }

    static String convertDigitToString(int lastDigit) {
        String result = "";
        switch (lastDigit) {
            case 0:
                result = "zero";
                break;
            case 1:
                result = "one";
                break;
            case 2:
                result = "two";
                break;
            case 3:
                result = "three";
                break;
            case 4:
                result = "four";
                break;
            case 5:
                result = "five";
                break;
            case 6:
                result = "six";
                break;
            case 7:
                result = "seven";
                break;
            case 8:
                result = "eight";
                break;
            case 9:
                result = "nine";
                break;
        }
        return result;
    }
}
