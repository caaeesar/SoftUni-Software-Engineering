package TextProcessing.exercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String encryptedMessage = encryptText(message);
        System.out.println(encryptedMessage);

    }

    static String encryptText(String message) {
        StringBuilder encryptedMessage = new StringBuilder(message.length());

        for (int index = 0; index < message.length(); index++) {
            char symbol = message.charAt(index);
            if (symbol == ' ') {
                encryptedMessage.append("#");
            } else {
                symbol += 3;
                encryptedMessage.append(symbol);
            }
        }
        return encryptedMessage.toString();
    }
}
