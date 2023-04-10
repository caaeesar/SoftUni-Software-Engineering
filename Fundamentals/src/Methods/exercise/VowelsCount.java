package Methods.exercise;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int vowels = countVowels(text);
        System.out.print(vowels);
    }

    private static int countVowels(String text) {
        int count = 0;
        for (int position = 0; position < text.length(); position++) {
            char letter = text.charAt(position);

            switch (letter) {

                case 'A':
                case 'a':
                case 'E':
                case 'e':
                case 'I':
                case 'i':
                case 'O':
                case 'o':
                case 'U':
                case 'u':
                    count++;
            }
        }
        return count;
    }
}
