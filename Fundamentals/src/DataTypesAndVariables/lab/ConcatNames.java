package DataTypesAndVariables.lab;

import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        String delimiter = scanner.nextLine();

        String[] array = new String[2];
        array[0] = firstName;
        array[1] = secondName;

        System.out.print(String.join(delimiter,array));
    }
}
