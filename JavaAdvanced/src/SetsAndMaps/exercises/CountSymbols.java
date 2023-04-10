package SetsAndMaps.exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer>  occurrences = new TreeMap<>();

        String text = scanner.nextLine();
        for (int position = 0; position < text.length(); position++) {

            char symbol = text.charAt(position);

            Integer count = occurrences.get(symbol);
            if (count == null) {
                count = 0;
            }
            occurrences.put(symbol,count + 1);
        }
        occurrences.forEach((symbol,count) -> System.out.printf("%c: %d time/s\n",symbol,count));
    }
}
