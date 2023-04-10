package Exams.Final.Exam_03;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder activationKey = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!"Generate".equals(input)) {

            String[] parts = input.split(">>>");
            String command = parts[0];
            int startIndex;
            int endIndex;

            switch (command) {
                case "Contains":
                    String substring = parts[1];
                    if (activationKey.toString().contains(substring)) {
                        System.out.printf("%s contains %s\n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");

                    }
                    input = scanner.nextLine();
                    continue;
                case "Flip":
                    String upperOrLower = parts[1];
                    startIndex = Integer.parseInt(parts[2]);
                    endIndex = Integer.parseInt(parts[3]);
                    String str = activationKey.substring(startIndex, endIndex);

                    if (upperOrLower.equals("Upper")) {
                        for (int position = 0; position < str.length(); position++) {
                            str = str.toUpperCase();
                        }
                    } else if (upperOrLower.equals("Lower")) {
                        for (int position = 0; position < str.length(); position++) {
                            str = str.toLowerCase();
                        }
                    }
                    activationKey.replace(startIndex, endIndex, str);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(parts[1]);
                    endIndex = Integer.parseInt(parts[2]);
                    activationKey.delete(startIndex, endIndex);
                    break;
            }
            System.out.println(activationKey);
            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", activationKey);
    }
}
