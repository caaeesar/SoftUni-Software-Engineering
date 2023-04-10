package TextProcessing.exercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         * String[] line = scanner.nextLine().split("\\s+");
         *         double totalSum = 0.00;
         *
         *         for (String s : line) {
         *
         *             double number = modifyingNumber(s);
         *             totalSum += number;
         *         }
         *         System.out.printf("%.2f", totalSum);
         *     }
         *
         *     static double modifyingNumber(String str) {
         *
         *         char firstLetter = str.charAt(0);
         *         char secondLetter = str.charAt(str.length() - 1);
         *         double number = Double.parseDouble(str
         *                 .replace(firstLetter, ' ')
         *                 .replace(secondLetter, ' ')
         *                 .trim());
         *         int letterPosition = 0;
         *
         *         // [65 - 90] -> 64
         *         if (Character.isUpperCase(firstLetter)) {
         *             letterPosition = (int) firstLetter - 64;
         *             number = number / letterPosition;
         *         } else if (Character.isLowerCase(firstLetter)) { // [97 - 122] - > 96
         *             letterPosition =(int)firstLetter  - 96;
         *             number = number * letterPosition;
         *         }
         *
         *         if (Character.isUpperCase(secondLetter)) {
         *             letterPosition = (int)secondLetter  - 64;
         *             number  = number - letterPosition;
         *         } else if (Character.isLowerCase(secondLetter)) {
         *             letterPosition = (int)secondLetter  - 96;
         *             number  = number + letterPosition;
         *         }
         *         return number;
         *     }
         */
        String[] parts = scanner.nextLine().split("\\s+");
        double totalSum = 0.00;

        for (String originalStr : parts) {

            StringBuilder modifiedStr = new StringBuilder(originalStr);
            // get letters
            char firstLetter = originalStr.charAt(0);
            char lastLetter = originalStr.charAt(originalStr.length() - 1);
            // delete letters
            modifiedStr.deleteCharAt((originalStr.length() - 1));
            modifiedStr.deleteCharAt(0);

            double number = Integer.parseInt(modifiedStr.toString());

            number = leftOperations(firstLetter, number);
            number = rightOperations(lastLetter, number);

            totalSum += number;
        }
        System.out.printf("%.2f", totalSum);
    }

    public static double leftOperations(char letter, double number) {
        double sum = 0.00;
        int asciiCode = letter;
        double alphabeticalCode;
        if (Character.isUpperCase(letter)) {
            alphabeticalCode = asciiCode - 64;
            sum = number / alphabeticalCode;
        } else if (Character.isLowerCase(letter)) {
            alphabeticalCode = asciiCode - 96;
            sum = number * alphabeticalCode;
        }
        return sum;
    }

    public static double rightOperations(char letter, double number) {
        double sum = 0.00;
        int asciiCode = letter;
        double alphabeticalCode;
        if (Character.isUpperCase(letter)) {
            alphabeticalCode = asciiCode - 64;
            sum = number - alphabeticalCode;
        } else if (Character.isLowerCase(letter)) {
            alphabeticalCode = asciiCode - 96;
            sum = number + alphabeticalCode;
        }
        return sum;
    }
}
