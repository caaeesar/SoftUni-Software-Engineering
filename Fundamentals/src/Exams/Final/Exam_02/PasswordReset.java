package Exams.Final.Exam_02;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder currentPass = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!"Done".equals(input)) {

            String[] parts = input.split("\\s");
            String command = parts[0];

            switch (command) {
                case "TakeOdd":
                    currentPass = concatenateOddSymbols(currentPass);
                    break;
                case "Cut":
                    int index = Integer.parseInt(parts[1]);
                    int length = Integer.parseInt(parts[2]);
                    currentPass = deletingSymbols(index, length, currentPass);
                    break;
                case "Substitute":
                    String substring = parts[1];
                    String substitute = parts[2];
                    int i = currentPass.indexOf(substring);
                    if (i != -1 && (!substitute.equals(substring))) {
                        currentPass = new StringBuilder(currentPass.toString().replace(substring, substitute));
                    } else {
                        System.out.println("Nothing to replace!");
                        input = scanner.nextLine();
                        continue;
                    }
                    break;
            }
            System.out.println(currentPass);
            input = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", currentPass);
    }

    private static StringBuilder deletingSymbols(int index, int length, StringBuilder newPass) {
        String str = newPass.substring(index, index + length);
        int firstOcc = newPass.indexOf(str);
        return newPass.delete(firstOcc, (firstOcc + str.length()));
    }

    private static StringBuilder concatenateOddSymbols(StringBuilder currentPass) {
        StringBuilder newPass = new StringBuilder();
        for (int position = 1; position < currentPass.length(); position += 2) {
            newPass = new StringBuilder(newPass.append(currentPass.charAt(position)));
        }
        return newPass;
    }
}
