package DataTypesAndVariables.lab;

import java.util.Arrays;
import java.util.Scanner;

public class CharsToString {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        char[] symbols = new char[3];

        for (int index = 0; index < 3; index++) {

            char currentSymbol = scanner.nextLine().charAt(0);
            symbols[index] = currentSymbol;
        }
        for (char c : symbols) {
            System.out.print(c);
        }
    }
}
