package Exams.FinaleRetake.Exam_01;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        StringBuilder decryptedMessage = new StringBuilder(encryptedMessage);

        String input = scanner.nextLine();
        while (!"Decode".equals(input)) {

            String[] parts = input.split("\\|");
            String command = parts[0];
            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(parts[1]);
                    movingLetters(decryptedMessage, numberOfLetters);
                    break;
                case "Insert":
                    int index = Integer.parseInt(parts[1]);
                    String value = parts[2];
                    insertingLetter(decryptedMessage, index, value);
                    break;
                case "ChangeAll":
                    String substring = parts[1];
                    String replacement = parts[2];
                    String str = decryptedMessage.toString().replace(substring,replacement);
                    decryptedMessage = new StringBuilder(str);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", decryptedMessage);
    }

    private static void insertingLetter(StringBuilder decryptedMessage, int index, String value) {
        decryptedMessage.insert(index, value);
    }

    private static void movingLetters(StringBuilder decryptedMessage, int numberOfLetters) {
        int count = 0;
        while (count < numberOfLetters) {
            char symbol = decryptedMessage.charAt(0);
            decryptedMessage.append(symbol);
            decryptedMessage.deleteCharAt(0);
            count++;
        }
    }
}
