package PBExams.Exam17Decembre17;

import java.util.Arrays;
import java.util.Scanner;

public class NewCoin {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printFirstRow(n);
        printFirstPart(n);
        printMiddle(n);
        printHead(n);
        printMiddle(n);
        printSecondPart(n);
        printLastRow(n);
    }

    static void printFirstRow(int n) {
        String backSlash = repeatStr(n, "\\");
        String slash = repeatStr(n, "/");
        String space = repeatStr(n * 2, " ");
        System.out.println(space + backSlash + slash);
    }

    static void printSecondPart(int n) {
        int rows = n - 1;
        int countSpace = 2;
        int countSlashes = 1;
        int countDashes = (n * 6) - (countSpace * 2) - (countSlashes * 2);
        String currentLine = "";

        for (int currentRow = 1; currentRow <= rows; currentRow++) {

            currentLine += repeatStr(countSpace, " ");
            currentLine += repeatStr(countSlashes, "/");
            currentLine += repeatStr(countDashes, "-");
            currentLine += repeatStr(countSlashes, "\\");

            countSlashes++;
            countDashes -= 6;
            countSpace += 2;
            System.out.println(currentLine);
            currentLine = "";
        }
    }

    static void printFirstPart(int n) {
        int rows = n - 1;
        int countSlashes = n - 1;
        int countDashes = 6;
        String currentLine = "";
        int countSpace = (n * 2) - 2;

        for (int currentRow = 1; currentRow <= rows; currentRow++) {

            currentLine += repeatStr(countSpace, " ");
            currentLine += repeatStr(countSlashes, "\\");
            currentLine += repeatStr(countDashes, "-");
            currentLine += repeatStr(countSlashes, "/");

            countSlashes--;
            countDashes += 6;
            countSpace -= 2;
            System.out.println(currentLine);
            currentLine = "";
        }
    }

    static void printMiddle(int n) {
        int rows = 0;
        if (n % 2 == 0) {
            rows = n - 2;
        } else {
            rows = n - 3;
        }
        int countDash = n - 1;
        int countHash = (n * 6) - 2 - (countDash * 2);

        for (int currentRow = 1; currentRow <= (rows / 2); currentRow++) {

            String currentLine = "";

            currentLine += "|";

            currentLine += repeatStr(countDash, "-");

            currentLine += repeatStr(countHash, "#");

            currentLine += repeatStr(countDash, "-");

            currentLine += "|";

            System.out.println(currentLine);
        }
    }

    static void printHead(int n) {
        String line = "|";
        line += repeatStr(n - 1, "~");

        int totalCols = n * 6;
        int countSlashes = ((totalCols - 8) - ((n - 1) * 2)) / 2;
        line += repeatStr(countSlashes, "/");

        line += " ESTD ";
        line += repeatStr(countSlashes, "\\");
        line += repeatStr(n - 1, "~");
        line += "|";

        System.out.println(line);
    }

    static void printLastRow(int n) {
        String slash = repeatStr(n, "/");
        String backSlash = repeatStr(n, "\\");
        String space = repeatStr(n * 2, " ");
        System.out.println(space + slash + backSlash);
    }

    static String repeatStr(int size, String symbol) {
        String[] currentSymbols = new String[size];
        Arrays.fill(currentSymbols, symbol);
        return String.join("", currentSymbols);
    }
}
