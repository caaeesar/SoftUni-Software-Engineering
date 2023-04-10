package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class DemoChar {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        char operation = scanner.nextLine().charAt(0);

        if (operation == '+' || operation == '-') { // сравняване на char (като числата)
            System.out.printf("4 %c 6",operation);
        }
    }
}
