package DataTypesAndVariables.lab;

import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        char c = scanner.nextLine().charAt(0);

        if (Character.isUpperCase(c)) {
            System.out.print("upper-case");
        } else {
            System.out.print("lower-case");
        }

    }
}
