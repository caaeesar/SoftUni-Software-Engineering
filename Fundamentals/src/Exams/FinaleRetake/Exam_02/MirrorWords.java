package Exams.FinaleRetake.Exam_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String inputStr = scanner.nextLine();
        List<String> validPairs = new ArrayList<>();
        List<String> mirrorPairs = new ArrayList<>();

        boolean areHaveMirrorPair = false;
        int countValidPairs = 0;

        String validPairRegex = "([@#]){1}(?<firstWord>[A-Za-z]{3,})\\1{2}(?<secondWord>[A-Za-z]{3,})\\1{1}";
        Pattern validPairPattern = Pattern.compile(validPairRegex);
        Matcher validPairMatcher = validPairPattern.matcher(inputStr);

        while (validPairMatcher.find()) {
            countValidPairs++;
            validPairs.add(validPairMatcher.group());

            String firstWord = validPairMatcher.group("firstWord");
            StringBuilder secondWord = new StringBuilder(validPairMatcher.group("secondWord"));
            String word2 = secondWord.reverse().toString();

            if (firstWord.equals(word2)) {
                areHaveMirrorPair = true;
                StringBuilder entryMirrorPair = new StringBuilder();
                entryMirrorPair.append(firstWord);
                entryMirrorPair.append(" <=> ");
                entryMirrorPair.append(secondWord.reverse());
                mirrorPairs.add(entryMirrorPair.toString());
            }
        }

        if (countValidPairs == 0) {
            System.out.println("No word pairs found!");
            if (!areHaveMirrorPair) {
                System.out.println("No mirror words!");
            }
        } else {
            System.out.printf("%d word pairs found!\n", countValidPairs);
            if (!areHaveMirrorPair) {
                System.out.println("No mirror words!");
            } else {
                System.out.println("The mirror words are:");
                System.out.println(String.join(", ", mirrorPairs));
            }
        }
    }
}
