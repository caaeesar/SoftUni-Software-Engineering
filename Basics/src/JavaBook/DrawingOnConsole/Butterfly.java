package JavaBook.DrawingOnConsole;

import java.util.Scanner;

public class Butterfly {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int totalCols = (2 * n) - 1;
        int totalRows = 2 * (n - 2) + 1;

        //Първа част:
        for (int row = 1; row <= (totalRows - 1) / 2; row++) {

            if (row % 2 == 0) {

                String hyphen = repeatString("-", (totalCols - 3) / 2);
                String evenRow = hyphen + "\\" + " " + "/" + hyphen;
                System.out.println(evenRow);

            } else {
                String star = repeatString("*", (totalCols - 3) / 2);
                String oddRow = star + "\\" + " " + "/" + star;
                System.out.println(oddRow);
            }
        }
        //Средна част:
        String space = repeatString(" ", (totalCols - 1) / 2);
        String midRow = space + "@" + space;
        System.out.println(midRow);

        //Последна част:
        for (int row = 1; row <= (totalRows - 1) / 2; row++) {

            if (row % 2 == 0) {

                String hyphen = repeatString("-", (totalCols - 3) / 2);
                String evenRow = hyphen + "/" + " " + "\\" + hyphen;
                System.out.println(evenRow);

            } else {
                String star = repeatString("*", (totalCols - 3) / 2);
                String oddRow = star + "/" + " " + "\\" + star;
                System.out.println(oddRow);
            }
        }
    }

    static String repeatString(String str, int count) {
        String text = "";

        for (int row = 1; row <= count; row++) {
            text += str;
        }
        return text;
    }
}
