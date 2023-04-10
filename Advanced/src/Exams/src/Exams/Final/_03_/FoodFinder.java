package Exams.Final._03_;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class FoodFinder {

    public static String PEAR = "pear";
    public static String FLOUR = "flour";
    public static String PORK = "pork";
    public static String OLIVE = "olive";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(vowels::offer);

        Deque<String> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(consonants::push);

        String[] pearChars = new String[PEAR.length()];
        String[] flourChars = new String[FLOUR.length()];
        String[] porkChars = new String[PORK.length()];
        String[] oliveChars = new String[OLIVE.length()];


        while (!consonants.isEmpty()) {

            String vowel = vowels.poll();
            String consonant = consonants.pop();

            checkPear(pearChars, vowel, consonant);
            checkFlour(flourChars, vowel, consonant);
            checkPork(porkChars, vowel, consonant);
            checkOlive(oliveChars, vowel, consonant);

            vowels.offerLast(vowel);
        }

        StringBuilder foundWords = new StringBuilder();
        int totalWords = 0;
        if (String.join("", pearChars).equals(PEAR.toLowerCase())) {
            foundWords.append(PEAR.toLowerCase());
            foundWords.append(System.lineSeparator());
            totalWords++;
        }
        if (String.join("", flourChars).equals(FLOUR.toLowerCase())) {
            foundWords.append(FLOUR.toLowerCase());
            foundWords.append(System.lineSeparator());
            totalWords++;
        }
        if (String.join("", porkChars).equals(PORK.toLowerCase())) {
            foundWords.append(PORK.toLowerCase());
            foundWords.append(System.lineSeparator());
            totalWords++;
        }
        if (String.join("", oliveChars).equals(OLIVE.toLowerCase())) {
            foundWords.append(OLIVE.toLowerCase());
            totalWords++;
        }

        System.out.printf("Words found: %d\n", totalWords);
        System.out.println(foundWords);
    }

    private static void checkOlive(String[] oliveChars, String vowel, String consonant) {
        int index = OLIVE.indexOf(vowel);
        while (index != -1) {
            oliveChars[index] = vowel;
            OLIVE = OLIVE.replace(vowel, vowel.toUpperCase());
            index = OLIVE.indexOf(vowel);
        }
        index = OLIVE.indexOf(consonant);
        while (index != -1) {
            oliveChars[index] = consonant;
            OLIVE = OLIVE.replace(consonant, consonant.toUpperCase());
            index = OLIVE.indexOf(consonant);
        }
    }

    private static void checkPork(String[] porkChars, String vowel, String consonant) {
        int index = PORK.indexOf(vowel);
        while (index != -1) {
            porkChars[index] = vowel;
            PORK = PORK.replace(vowel, vowel.toUpperCase());
            index = PORK.indexOf(vowel);
        }
        index = PORK.indexOf(consonant);
        while (index != -1) {
            porkChars[index] = consonant;
            PORK = PORK.replace(consonant, consonant.toUpperCase());
            index = PORK.indexOf(consonant);
        }
    }

    private static void checkFlour(String[] flourChars, String vowel, String consonant) {
        int index = FLOUR.indexOf(vowel);
        while (index != -1) {
            flourChars[index] = vowel;
            FLOUR = FLOUR.replace(vowel, vowel.toUpperCase());
            index = FLOUR.indexOf(vowel);
        }
        index = FLOUR.indexOf(consonant);
        while (index != -1) {
            flourChars[index] = consonant;
            FLOUR = FLOUR.replace(consonant, consonant.toUpperCase());
            index = FLOUR.indexOf(consonant);
        }
    }

    private static void checkPear(String[] pearChars, String vowel, String consonant) {
        int index = PEAR.indexOf(vowel);
        while (index != -1) {
            pearChars[index] = vowel;
            PEAR = PEAR.replace(vowel, vowel.toUpperCase());
            index = PEAR.indexOf(vowel);
        }
        index = PEAR.indexOf(consonant);
        while (index != -1) {
            pearChars[index] = consonant;
            PEAR = PEAR.replace(consonant, consonant.toUpperCase());
            index = PEAR.indexOf(consonant);
        }
    }
}
