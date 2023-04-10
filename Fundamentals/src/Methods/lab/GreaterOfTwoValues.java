package Methods.lab;

import java.io.IOException;
import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {

            case "int":
                int a = Integer.parseInt(scanner.nextLine());
                int b = Integer.parseInt(scanner.nextLine());
                int biggerNumber = getMax(a, b);
                System.out.print(biggerNumber);
                break;
            case "char":
                    char symbol1 = scanner.nextLine().charAt(0);
                    char symbol2 = scanner.nextLine().charAt(0);
                    char greaterSymbol = getMax(symbol1, symbol2);
                    System.out.print(greaterSymbol);
                break;
            case "string":
                String text1 = scanner.nextLine();
                String text2 = scanner.nextLine();
                String greaterStr = getMax(text1, text2);
                System.out.print(greaterStr);
                break;
        }
    }

    static int getMax(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    static char getMax(char symbol1, char symbol2) {
        if (symbol1 > symbol2) {
            return symbol1;
        }
        return symbol2;
    }

    static String getMax(String text1, String text2) {
        if (text1.compareTo(text2) > 0) {
            return text1;
        }
        return text2;
    }
}
