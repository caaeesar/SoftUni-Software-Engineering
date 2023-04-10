package RegularExpressions.moreExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\|");

        String firstPart = line[0];
        String secondPart = line[1];
        String[] thirdPart = line[2].split(" ");

        Pattern patternCapitalLetters = Pattern.compile("([#]|[$]|[\\*]|[&]|[%])(?<capitalLetters>[A-Z]+)\\1");
        Matcher matcherCapitalLetters = patternCapitalLetters.matcher(firstPart);
        String capitalLetters = "";
        while (matcherCapitalLetters.find()) {
            capitalLetters = matcherCapitalLetters.group("capitalLetters");
        }

        Pattern patternLetterLength = Pattern.compile("(?<code>\\d+):(?<length>\\d{2})");
        Matcher matcherLetterLength = patternLetterLength.matcher(secondPart);
        Map<Character, Integer> wordLength = new HashMap<>();
        while (matcherLetterLength.find()) {

            int asciiCode = Integer.parseInt(matcherLetterLength.group("code"));
            char letter = (char) asciiCode;
            int length = Integer.parseInt(matcherLetterLength.group("length"));
            wordLength.putIfAbsent(letter, length);
        }

        for (int i = 0; i < capitalLetters.length(); i++) {
            char currentCapitalLetter = capitalLetters.charAt(i);

            for (Map.Entry<Character, Integer> entry : wordLength.entrySet()) {
                char letter = entry.getKey();
                int length = entry.getValue();
                for (String str : thirdPart) {

                    if (str.charAt(0) == letter && currentCapitalLetter == letter && str.length() == length + 1) {
                        System.out.println(str);
                    }
                }
            }
        }
    }
}
