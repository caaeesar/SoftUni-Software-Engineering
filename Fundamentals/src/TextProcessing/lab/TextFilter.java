package TextProcessing.lab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         * String[] bannedWords = scanner.nextLine().split(", ");
         *         String text = scanner.nextLine();
         *
         *         for (String currentBanWord : bannedWords) {
         *
         *             String replacedBanWord = censoringWord(currentBanWord.length());
         *
         *             int index = text.indexOf(currentBanWord);
         *             while (index != -1) {
         *
         *                 text = text.replace(currentBanWord, replacedBanWord);
         *                 index = text.indexOf(currentBanWord, index + currentBanWord.length());
         *             }
         *         }
         *         System.out.println(text);
         *     }
         *
         *     public static String censoringWord(int countRepeated) {
         *         String result = "*";
         *         return result.repeat(countRepeated);
         *     }
         */

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : bannedWords) {

            String asterisks = replaceWords(word.length());
            text = text.replace(word, asterisks);
        }
        System.out.println(text);
    }

    static String replaceWords(int count) {
        StringBuilder replacement = new StringBuilder();
        for (int i = 0; i < count; i++) {
            replacement.append("*");
        }
        return replacement.toString();
    }
}
