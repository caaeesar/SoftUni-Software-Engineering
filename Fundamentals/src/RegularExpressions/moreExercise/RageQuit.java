package RegularExpressions.moreExercise;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String sequences = scanner.nextLine().toUpperCase();
        StringBuilder message = new StringBuilder();

        Pattern pattern = Pattern.compile("(?<symbols>\\D+)(?<times>\\d+)");
        Matcher matcher = pattern.matcher(sequences);

        while (matcher.find()) {

            String symbols = matcher.group("symbols");
            int repetitions = Integer.parseInt(matcher.group("times"));

            for (int i = 0; i < repetitions; i++) {
                message.append(symbols);
            }
        }

        Set<Character> uniqueSymbols = new HashSet<>();
        for (int index = 0; index < message.length(); index++) {
            char currentSymbol = message.charAt(index);
                uniqueSymbols.add(currentSymbol);
        }
        System.out.printf("Unique symbols used: %d%n", uniqueSymbols.size());
        System.out.printf("%s", message);
    }
}
