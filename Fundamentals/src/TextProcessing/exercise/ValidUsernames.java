package TextProcessing.exercise;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (String currentUsername : usernames) {

            int length = currentUsername.length();
            boolean isValidLength = (length >= 3) && (length <= 16);

            char[] charArray = currentUsername.toCharArray();
            boolean isValidContains = true;

            for (Character symbol : charArray) {

                if (!Character.isLetterOrDigit(symbol)
                        && symbol != '-' && symbol != '_') {
                    isValidContains = false;
                    break;
                }
            }
            if (isValidLength && isValidContains) {
                System.out.println(currentUsername);
            }
        }
    }
}
