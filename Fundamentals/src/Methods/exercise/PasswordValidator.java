package Methods.exercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        boolean condition1 = checkCondition1(password);
        if (!condition1) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        boolean condition2 = checkCondition2(password);
        if (!condition2) {
            System.out.println("Password must consist only of letters and digits");
        }
        boolean condition3 = checkCondition3(password);
        if (!condition3) {
            System.out.println("Password must have at least 2 digits");
        }

        if (condition1 && condition2 && condition3) {
            System.out.print("Password is valid");
        }
    }

    static boolean checkCondition1(String password) {
        int length = password.length();
        if (length >= 6 && length <= 10) {
            return true;
        }
        return false;
    }

    static boolean checkCondition2(String password) {
        boolean isValid = false;
        for (int position = 0; position < password.length(); position++) {
            char symbol = password.charAt(position);
            boolean isHaveDigits = symbol >= 48 && symbol <= 57; //digits
            boolean isHaveLETTER = symbol >= 65 && symbol <= 90; //capital letter
            boolean isHaveLetter = symbol >= 97 && symbol <= 122; //lower letter

            if (isHaveDigits || isHaveLETTER || isHaveLetter) {
                isValid = true;
            } else {
                return false;
            }
        }
        return isValid;
    }

    static boolean checkCondition3(String password) {

        int countDigit = 0;
        for (int position = 0; position < password.length(); position++) {
            char symbol = password.charAt(position);

            if (symbol >= 48 && symbol <= 57) {
                countDigit++;
            }
        }
        if (countDigit < 2) {
            return false;
        }
        return true;
    }
}
