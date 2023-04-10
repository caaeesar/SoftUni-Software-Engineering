package Exams.Final.Exam_03;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String digitRegex = "\\d";
        Pattern digitsPattern = Pattern.compile(digitRegex);
        Matcher digitsMatcher = digitsPattern.matcher(text);
        BigInteger coolThresholdSum = new BigInteger("1");
        while (digitsMatcher.find()) {
            int currentDigit = Integer.parseInt(digitsMatcher.group());
            coolThresholdSum = coolThresholdSum.multiply(BigInteger.valueOf(currentDigit));
        }

        String emojiRegex = "([:*]){2}[A-Z][a-z]{2,}\\1{2}";
        Pattern emojiPattern = Pattern.compile(emojiRegex);
        Matcher emojiMatcher = emojiPattern.matcher(text);
        List<String> validEmoji = new ArrayList<>();
        while (emojiMatcher.find()) {
            validEmoji.add(emojiMatcher.group());
        }

        List<String> coolEmoji = new ArrayList<>();
        for (String emoji : validEmoji) {
            BigInteger currentAsciiSum = new BigInteger("0");

            for (int position = 0; position < emoji.length(); position++) {
                char symbol = emoji.charAt(position);
                if (symbol != ':' && symbol != '*') {
                    currentAsciiSum = currentAsciiSum.add(BigInteger.valueOf(symbol));
                }
            }
            if (currentAsciiSum.compareTo(coolThresholdSum) >= 0) {
                coolEmoji.add(emoji);
            }
        }
        System.out.printf("Cool threshold: %d\n", coolThresholdSum);
        System.out.printf("%d emojis found in the text. The cool ones are:\n", validEmoji.size());
        for (String emoji : coolEmoji) {
            System.out.println(emoji);
        }
    }
}
