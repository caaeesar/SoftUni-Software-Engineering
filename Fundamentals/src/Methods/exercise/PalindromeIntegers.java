package Methods.exercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!"END".equals(command)) {

            String currentNumber = command;
            String backwardNum = "";
            for (int i = currentNumber.length() - 1; i >= 0; i--) {
                char digit = currentNumber.charAt(i);
                backwardNum += digit;
            }
            if (currentNumber.equals(backwardNum)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            command = scanner.nextLine();
        }
    }
}
