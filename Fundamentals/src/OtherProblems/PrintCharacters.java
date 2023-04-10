package OtherProblems;

import java.util.Scanner;

public class PrintCharacters {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);
        int n = Integer.parseInt(scanner.nextLine());

        printChar(symbol1,symbol2,n);
    }

    static void printChar(char c1, char c2, int end) {
        int count = 0;
        for (int currentSymbol = c1 + 1; currentSymbol < c2; currentSymbol++) {
            count++;
            if (count != end) {
                System.out.printf("%c ",currentSymbol);
            }
        }
    }
}
