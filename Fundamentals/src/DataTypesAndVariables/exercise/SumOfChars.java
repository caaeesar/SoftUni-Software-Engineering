package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumOfSymbols = 0;

        for (int currentChar = 0; currentChar < n; currentChar++) {

            char symbol = scanner.nextLine().charAt(0);
            sumOfSymbols += symbol;
        }
        System.out.printf("The sum equals: %d", sumOfSymbols);
    }
}
