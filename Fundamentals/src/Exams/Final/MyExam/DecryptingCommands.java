package Exams.Final.MyExam;

import java.util.Scanner;

public class DecryptingCommands {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder encryptedMessage = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!"Finish".equals(input)) {

            String[] parts = input.split("\\s+");
            String command = parts[0];

            int startIndex;
            int endIndex;
            boolean isStartIndexValid = false;
            boolean isEndIndexValid = false;

            switch (command) {

                case "Replace":
                    String currentChar = parts[1];
                    String newChar = parts[2];
                    encryptedMessage = new StringBuilder(encryptedMessage.toString().replace(currentChar, newChar));
                    break;

                case "Cut":
                    startIndex = Integer.parseInt(parts[1]);
                    endIndex = Integer.parseInt(parts[2]);

                    if (startIndex >= 0 && startIndex < encryptedMessage.length()) {
                        isStartIndexValid = true;
                    }
                    if (endIndex >= 0 && endIndex < encryptedMessage.length()) {
                        isEndIndexValid = true;
                    }
                    if (!isStartIndexValid || !isEndIndexValid) {
                        System.out.println("Invalid indices!");
                        input = scanner.nextLine();
                        continue;
                    } else {
                        encryptedMessage.delete(startIndex, endIndex + 1);
                    }
                    break;

                case "Make":
                    String upperLower = parts[1];
                    if (upperLower.equals("Upper")) {
                        encryptedMessage = new StringBuilder(encryptedMessage.toString().toUpperCase());
                    } else if (upperLower.equals("Lower")) {
                        encryptedMessage = new StringBuilder(encryptedMessage.toString().toLowerCase());
                    }
                    break;

                case "Check":
                    String str = parts[1];
                    if (encryptedMessage.toString().contains(str)) {
                        System.out.printf("Message contains %s\n", str);
                    } else {
                        System.out.printf("Message doesn't contain %s\n", str);
                    }
                    input = scanner.nextLine();
                    continue;

                case "Sum":
                    startIndex = Integer.parseInt(parts[1]);
                    endIndex = Integer.parseInt(parts[2]);

                    if (startIndex >= 0 && startIndex < encryptedMessage.length()) {
                        isStartIndexValid = true;
                    }
                    if (endIndex >= 0 && endIndex < encryptedMessage.length()) {
                        isEndIndexValid = true;
                    }
                    if (!isStartIndexValid || !isEndIndexValid) {
                        System.out.println("Invalid indices!");
                    } else {
                        String substring = encryptedMessage.substring(startIndex, endIndex + 1);
                        int asciiSum = 0;
                        for (int position = 0; position < substring.length(); position++) {
                            asciiSum += substring.charAt(position);
                        }
                        System.out.println(asciiSum);
                    }
                    input = scanner.nextLine();
                    continue;
            }
            System.out.println(encryptedMessage);
            input = scanner.nextLine();
        }
    }
}
