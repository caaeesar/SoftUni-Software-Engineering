package DataTypesAndVariables.lab;

import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] symbols = new String[3];

        for (int index = 3 - 1; index >= 0; index--) {

            char currentSymbol = scanner.nextLine().charAt(0);
            symbols[index] = String.valueOf(currentSymbol);
        }
        String result = String.join(" ", symbols);
        System.out.print(result);
    }
}
