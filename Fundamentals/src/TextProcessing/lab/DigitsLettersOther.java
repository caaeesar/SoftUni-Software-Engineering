package TextProcessing.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DigitsLettersOther {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        char[] charsSequence = scanner.nextLine().toCharArray();
        List<Character> symbols = new ArrayList<>();
        List<Character> digits = new ArrayList<>();
        List<Character> letters = new ArrayList<>();

        for(Character currentSymbol : charsSequence) {

            if (Character.isAlphabetic(currentSymbol)) {
                letters.add(currentSymbol);
            } else if (Character.isDigit(currentSymbol)) {
                digits.add(currentSymbol);
            } else {
                symbols.add(currentSymbol);
            }
        }
        System.out.println(digits.toString().replaceAll("[\\[\\],\\s]", ""));
        System.out.println(letters.toString().replaceAll("[\\[\\],\\s]", ""));
        System.out.println(symbols.toString().replaceAll("[\\[\\],\\s]", ""));
    }
}
