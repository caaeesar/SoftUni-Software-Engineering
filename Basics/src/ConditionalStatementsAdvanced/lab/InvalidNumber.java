package ConditionalStatementsAdvanced.lab;

import java.util.Scanner;

public class InvalidNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        boolean isValid = (((number >= 100) && (number <= 200)) || (number == 0));

        if (!isValid) {
            System.out.print("invalid");
        }
    }
}
