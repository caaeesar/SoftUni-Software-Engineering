package PFSchool;

import java.util.Scanner;

public class IndexByLetter {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] alphabet = new String[]{
                "a", "b", "c", "d", "e",
                "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o",
                "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y",
                "z"
        };
        String word = scanner.nextLine().toLowerCase();

        for (int position = 0; position < word.length(); position++) {

            for (int index = 0; index < alphabet.length; index++) {

                char symbol = word.charAt(position);
                if (!Character.isAlphabetic(symbol)) {
                    continue;
                }
                String letter = symbol + "";

                if (letter.equals(alphabet[index])) {
                    System.out.printf("%s -> %d%n", letter, index);
                }
            }
        }
    }
}
