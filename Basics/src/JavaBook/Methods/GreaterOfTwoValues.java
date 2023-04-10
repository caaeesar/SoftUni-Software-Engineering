package JavaBook.Methods;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        if (type.equals("int")) {

            int number1 = Integer.parseInt(scanner.nextLine());
            int number2 = Integer.parseInt(scanner.nextLine());
            int maxNumber = getMax(number1, number2);
            System.out.print(maxNumber);

        } else if (type.equals("char")) {

            char symbol1 = scanner.nextLine().charAt(0);
            char symbol2 = scanner.nextLine().charAt(0);
            char maxSymbol = getMax(symbol1, symbol2);
            System.out.print(maxSymbol);
        } else if (type.equals("string")) {

            String text1 = scanner.nextLine();
            String text2 = scanner.nextLine();
            String maxLength = getMax(text1, text2);
            System.out.print(maxLength);
        }
    }

    static String getMax(String str1, String str2) {

        // метода .compareTo() сравнява String-овете по Ascii таблицата;
        // връща числова стойност:
        // по-голяма от 0 (сравняваният обект е по-голям),
        // по-малка от 0 (сравняваният обект е по-малък)
        // 0 (при два еднакви обекта)

        if (str1.compareTo(str2) > 0) {
            return str1;
        } else {
            return str2;
        }
    }

    static char getMax(char c1, char c2) {

        if (c1 > c2) {
            return c1;
        } else {
            return c2;
        }
    }

    static int getMax(int num1, int num2) {

        return num1 > num2 ? num1 : num2;
    }
}
