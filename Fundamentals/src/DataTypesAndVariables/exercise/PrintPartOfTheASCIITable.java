package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class PrintPartOfTheASCIITable {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int firstSymbol = Integer.parseInt(scanner.nextLine());
        int endSymbol = Integer.parseInt(scanner.nextLine());

        /*for (int currentChar = firstSymbol; currentChar <= endSymbol ; currentChar++) {
            System.out.printf("%c ", currentChar);
        }*/

        for (char symbol = (char) firstSymbol; symbol <= endSymbol ; symbol++) {
            System.out.print(symbol + " ");
        }
    }
}
