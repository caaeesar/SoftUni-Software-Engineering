package MapsLambdaStreamAPI.exercise;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         * char[] charArray = scanner.nextLine().toCharArray();
         *         Map<Character,Integer> charsOccurrences = new LinkedHashMap<>();
         *
         *         for (char symbol : charArray) {
         *             if (symbol != 32) {
         *
         *                 Integer currentOccurrences = charsOccurrences.get(symbol);
         *                 if (currentOccurrences == null) {
         *                     currentOccurrences = 0;
         *                 }
         *                 charsOccurrences.put(symbol, currentOccurrences + 1);
         *             }
         *         }
         *         for (Map.Entry<Character,Integer> entry : charsOccurrences.entrySet()) {
         *             System.out.printf("%c -> %d\n", entry.getKey(),entry.getValue());
         *         }
         */

        String[] words = scanner.nextLine().split(" ");
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        for (String word : words) {

            for (int position = 0; position < word.length(); position++) {

                Character currentSymbol = word.charAt(position);

               if (!charCount.containsKey(currentSymbol)) {
                   charCount.put(currentSymbol, 1);
               } else {
                   charCount.put(currentSymbol, charCount.get(currentSymbol) + 1);
               }
            }
        }
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue() );
        }
    }
}
