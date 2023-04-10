package JavaBook.Methods;

import java.util.Scanner;

public class DrawAFilledSquare {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String firstLastRow = repeatString("-", n * 2);

        System.out.println(firstLastRow);

        for (int midRow = 0; midRow < n - 2; midRow++) {

            String dash = repeatString("\\/", n - 1);
            String currentMidRow = "-" + dash + "-";
            System.out.println(currentMidRow);
        }
        System.out.println(firstLastRow);
    }

    static String repeatString(String str, int count) {

        String text = "";

        for (int i = 1; i <= count; i++) {

            text += str;
        }
        return text;
    }

}
