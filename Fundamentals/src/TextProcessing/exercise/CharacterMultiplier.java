package TextProcessing.exercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         * String[] input = scanner.nextLine().split(" ");
         *         char[] str1 = input[0].toCharArray();
         *         char[] str2 = input[1].toCharArray();
         *         int totalSum = 0;
         *
         *         for (int currentIndex = 0; currentIndex < Math.min(str1.length, str2.length); currentIndex++) {
         *
         *             int symbolCode1 = str1[currentIndex];
         *             int symbolCode2 = str2[currentIndex];
         *
         *             totalSum += (symbolCode1 * symbolCode2);
         *         }
         *
         *         if (str1.length != str2.length) {
         *             char[] longerArray;
         *             char[] smallerArray;
         *             if (str1.length > str2.length) {
         *                 longerArray = str1;
         *                 smallerArray = str2;
         *             } else {
         *                 longerArray = str2;
         *                 smallerArray = str1;
         *             }
         *
         *             for (int i = smallerArray.length; i < longerArray.length; i++) {
         *                 int remainderSymbolCode = longerArray[i];
         *                 totalSum += remainderSymbolCode;
         *             }
         *         }
         *         System.out.print(totalSum);
         */

        String[] input = scanner.nextLine().split(" ");
        StringBuilder str1 = new StringBuilder(input[0]);
        StringBuilder str2 = new StringBuilder(input[1]);
        int length1 = str1.length();
        int length2 = str2.length();
        int totalSum = 0;

        if (length1 > length2) {

            int remainedChars = length1 - length2;
            int countChars = 0;
            for (int index = length1 - 1; index >= 0; index--) {
                char symbol = str1.charAt(index);
                totalSum += symbol;
                countChars++;
                str1.deleteCharAt(index);
                if (remainedChars == countChars) {
                    break;
                }
            }

        } else if (length2 > length1) {

            int remainedChars = length2 - length1;
            int countChars = 0;
            for (int index = length2 - 1; index >= 0; index--) {
                char symbol = str2.charAt(index);
                totalSum += symbol;
                countChars++;
                str2.deleteCharAt(index);
                if (remainedChars == countChars) {
                    break;
                }
            }
        }
        int sum = multiplierCharacter(str1, str2);
        totalSum += sum;
        System.out.println(totalSum);
    }

    static int multiplierCharacter(StringBuilder str1, StringBuilder str2) {
        int sum = 0;

        for (int index = 0; index < str1.length(); index++) {
            char symbol1 = str1.charAt(index);
            char symbol2 = str2.charAt(index);
            sum += symbol1 * symbol2;
        }
        return sum;
    }
}
