package DataTypesAndVariables.lab;

import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double pounds = Double.parseDouble(scanner.nextLine());
        // 1 British Pound = 1.36 Dollars
        double dollars = pounds * 1.36;
        System.out.printf("%.3f", dollars);
    }
}
