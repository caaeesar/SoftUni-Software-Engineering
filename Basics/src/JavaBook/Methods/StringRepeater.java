package JavaBook.Methods;

import java.util.Scanner;

public class StringRepeater {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        System.out.print(repeatString(text, count));
    }

    static String repeatString(String str, int count) {

        return str.repeat(count);

        /*String text = "";
        for (int i = 1; i <= count; i++) {
            text += str;
        }
        return text;*/
    }
}
