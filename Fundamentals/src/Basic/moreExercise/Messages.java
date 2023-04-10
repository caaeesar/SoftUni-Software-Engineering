package Basic.moreExercise;

import java.util.Scanner;

public class Messages {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int lettersCount = Integer.parseInt(scanner.nextLine());
        StringBuilder message = new StringBuilder();

        for (int i = 1; i <= lettersCount; i++) {

            String digitSet = scanner.nextLine();
            char singleDigit = digitSet.charAt(0);
            String charSet = "";

            switch (singleDigit) {
                case '0':
                    message.append(" ");
                    continue;
                case '2':
                    charSet = "abc";
                    break;
                case '3':
                    charSet = "def";
                    break;
                case '4':
                    charSet = "ghi";
                    break;
                case '5':
                    charSet = "jkl";
                    break;
                case '6':
                    charSet = "mno";
                    break;
                case '7':
                    charSet = "pqrs";
                    break;
                case '8':
                    charSet = "tuv";
                    break;
                case '9':
                    charSet = "wxyz";
                    break;
            }
            int length = digitSet.length();
            message.append(charSet.charAt(length - 1));
        }
        System.out.println(message);

    }
}
