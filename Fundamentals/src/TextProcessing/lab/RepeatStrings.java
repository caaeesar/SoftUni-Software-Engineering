package TextProcessing.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         * String[] words = scanner.nextLine().split(" ");
         *         StringBuilder sb = new StringBuilder();
         *
         *         for (int currentWordIndex = 0; currentWordIndex < words.length; currentWordIndex++) {
         *             StringBuilder str = repeatedString(words[currentWordIndex], words[currentWordIndex].length());
         *             sb.append(str);
         *         }
         *         System.out.print(String.join("", sb));
         *     }
         *
         *     public static StringBuilder repeatedString(String word, int count) {
         *         StringBuilder sb = new StringBuilder();
         *         for (int i = 1; i <= count; i++) {
         *             sb.append(word);
         *         }
         *         return sb;
         *     }
         */

        String[] array = scanner.nextLine().split(" ");
        List<String> concatenatedString = new ArrayList<>();

        for (String str : array) {

            String repeatedStr = repeatsStrings(str, str.length());
            concatenatedString.add(repeatedStr);
        }
        System.out.println(String.join("", concatenatedString));
    }

    static String repeatsStrings(String str, int count) {
        StringBuilder repeatedString = new StringBuilder();
        for (int index = 0; index < count; index++) {
            repeatedString.append(str);
        }
       return repeatedString.toString();
    }
}
