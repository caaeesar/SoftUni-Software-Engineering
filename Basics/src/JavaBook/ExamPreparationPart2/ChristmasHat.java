package JavaBook.ExamPreparationPart2;

import java.util.Scanner;

public class ChristmasHat {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int totalCols = 4 * n + 1;
        int totalRows = 2 * n + 5;

        // ПЪРВА ЧАСТ: първите три реда
        int countDot = (totalCols - 3) / 2;
        String dot = repeatString(".", (countDot));
        System.out.printf("%s/|\\%s\n", dot, dot);

        System.out.printf("%s\\|/%s\n", dot, dot);

        System.out.printf("%s***%s\n", dot, dot);

        // ВТОРА ЧАСТ:
        int countDash = 1;
        for (int currentRow = 1; currentRow <= totalRows - 6; currentRow++) {
            countDot--;
            String midDot = repeatString(".", countDot);
            String dash = repeatString("-", countDash);
            System.out.printf("%s*%s*%s*%s\n", midDot, dash, dash, midDot);
            countDash++;
        }

        // ТРЕТА ЧАСТ: последните три реда
        String star = repeatString("*", totalCols);
        System.out.println(star);

        String starDot = repeatString("*.", totalCols / 2);
        System.out.println(starDot + "*");

        System.out.println(star);
    }

    static String repeatString(String str, int count) {
        StringBuilder text = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            text.append(str);
        }
        return text.toString();
    }
}

