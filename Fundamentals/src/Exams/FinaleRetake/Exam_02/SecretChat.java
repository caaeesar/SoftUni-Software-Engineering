package Exams.FinaleRetake.Exam_02;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder encryptedText = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!"Reveal".equals(input)) {

            String[] parts = input.split(":\\|:");
            String command = parts[0];
            StringBuilder substring;

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(parts[1]);
                    encryptedText.insert(index, " ");
                    break;
                case "Reverse":
                    substring = new StringBuilder(parts[1]);
                    if (encryptedText.toString().contains(substring)) {
                        int startIndex = encryptedText.indexOf(substring.toString());
                        encryptedText.delete(startIndex, startIndex + substring.length());
                        encryptedText.append(substring.reverse());
                    } else {
                        System.out.println("error");
                        input = scanner.nextLine();
                        continue;
                    }
                    break;
                case "ChangeAll":
                    substring = new StringBuilder(parts[1]);
                    String replacement = parts[2];
                    encryptedText = new StringBuilder(encryptedText.toString().replace(substring, replacement));
                    break;
            }
            System.out.println(encryptedText);
            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", encryptedText);
    }
}
