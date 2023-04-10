package JavaBook.DrawingOnConsole;

import java.util.Scanner;

public class Stop {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int countDots = n + 1;
        int countUnderscores = (n * 2) + 1;
        int countNextUnderscores = ((n * 2) + 1) - 2;
        int totalCols = (countDots * 2) + countUnderscores;
        int countMidRows = 0;

        //начален ред:
        String dots = repeatString(".", countDots);
        String underscores = repeatString("_", countUnderscores);
        // String firstRow = dots + underscores + dots; // с конкатенацията става бавно и се получават безкрайни цикли !!!
        // System.out.println(firstRow);
        System.out.printf("%s%s%s%n", dots, underscores, dots);

        //следващите редове:
        for (int row = 1; row <= n; row++) {

            countMidRows++;
            countDots--;
            String nextDots = repeatString(".", countDots);
            String nextUnderscores = repeatString("_", countNextUnderscores);
            // String nextRows = nextDots + "//" + nextUnderscores + "\\\\" + nextDots;
            // System.out.println(nextRows);
            System.out.printf("%s//%s\\\\%s%n", nextDots, nextUnderscores, nextDots);
            countNextUnderscores += 2;
        }

        //средна част:
        String midUnderscores = repeatString("_", (totalCols - 9) / 2);
        //  String midRow = "//" + midUnderscores + "STOP!" + midUnderscores + "\\\\";
        // System.out.println(midRow);
        System.out.printf("//%sSTOP!%s\\\\%n", midUnderscores, midUnderscores);

        //първи ред от последната част:
        String firstUnderscoresLastPart = repeatString("_", totalCols - 4);
        // String firstRowLastPart = "\\\\" + firstUnderscoresLastPart + "//";
        // System.out.println(firstRowLastPart);
        System.out.printf("\\\\%s//%n", firstUnderscoresLastPart);

        //последна част:
        int countLastDots = 1;

        for (int lastRows = 1; lastRows <= (countMidRows - 1); lastRows++) {

            int countLastUnderscores = (totalCols - 4) - (2 * countLastDots);
            String lastDots = repeatString(".", countLastDots);
            String lastUnderscores = repeatString("_", countLastUnderscores);
            // String currentLastRows = lastDots + "\\\\" + lastUnderscores + "//" + lastDots;
            // System.out.println(currentLastRows);
            System.out.printf("%s\\\\%s//%s%n", lastDots, lastUnderscores, lastDots);
            countLastDots++;
        }
    }

    static String repeatString(String str, int count) {
        StringBuilder text = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            text.append(str);
        }
        return text.toString();
    }
}
