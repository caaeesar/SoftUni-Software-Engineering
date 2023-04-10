package ForLoop.lab;

import java.util.Scanner;

public class CharacterSequence {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        //обхождане на String

        String input = scanner.nextLine();

        int length = input.length() - 1;

        for (int i = 0; i <= length; i++) {
            char symbol = input.charAt(i);
            System.out.println(symbol);
        }


    }
}
