package PBExams.Exam17Decembre17;

import java.util.Scanner;

public class Garage {
    static int count = 0;

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String firstRow = printFirstPart(n, '|');
        String secondRow = printFirstPart(n, '+');
        System.out.println(firstRow);
        System.out.println(secondRow);
        String slash = printHead(n);
        System.out.println(slash + "GARAGE" + slash);
        printMiddleParts(n);
        printDoor(n);
        String space = printLastPart(n);
        System.out.println(space + "/////" + space);
    }

    static String printFirstPart(int n, char symbol) {
        String result = "";
        for (int i = 1; i <= ((n * 2) + 2); i++) {

            result += symbol;
        }
        return result;
    }

    static String printHead(int n) {
        String result = "";

        int colum = (((n * 2) + 2) - 6) / 2;
        for (int i = 1; i <= colum; i++) {

            result += '|';
        }
        return result;
    }

    static void printMiddleParts(int n) {

        int row = ((n + 2) - 3) - 1;

        if (row >= 2) {
            row -= 2;
        } else {
            row -= 1;
        }

        for (int i = 1; i <= row; i++) {
            count++;
            for (int j = 1; j <= ((n * 2) + 2); j++) {

                System.out.printf("%c", '|');
            }
            System.out.println();
        }
    }

    static void printDoor(int n) {

        String mid = "";
        int row = ((n + 2) - 4) - count;
        int col = (((n * 2) + 2) - 8) / 2;

        for (int i = 1; i <= row; i++) {

            for (int j = 1; j <= col; j++) {

                mid += '/';
            }
            System.out.print("|" + mid + "|" + "    " + "|" + mid + "|");
            mid = "";
            System.out.println();
        }
    }

    static String printLastPart(int n) {

        String result = "";
        int col = (((n * 2) + 2) - 6) / 2;

        for (int i = 1; i <= col; i++) {

            result += " ";
        }
        return result;
    }
}
