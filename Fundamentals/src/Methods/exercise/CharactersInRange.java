package Methods.exercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        char c1 = scanner.nextLine().charAt(0);
        char c2 = scanner.nextLine().charAt(0);
        getCharacters(c1,c2);
    }

    static void getCharacters(char c1, char c2) {
        if (c1 < c2) {
        for (int currentChar = c1 + 1; currentChar < c2; currentChar++) {
            System.out.printf("%c ",currentChar);
        }
        } else {
            for (int currentChar = c2 + 1; currentChar < c1; currentChar++) {
                System.out.printf("%c ",currentChar);
            }
        }
    }
}
