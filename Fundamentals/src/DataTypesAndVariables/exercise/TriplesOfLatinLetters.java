package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (char firstLetter = 'a'; firstLetter < 'a' + n; firstLetter++) {
            for (char secondLetter = 'a'; secondLetter < 'a' + n; secondLetter++) {
                for (char thirdLetter = 'a'; thirdLetter < 'a' + n; thirdLetter++) {
                    System.out.printf("%c%c%c%n", firstLetter, secondLetter, thirdLetter);
                }
            }
        }
    }
}
