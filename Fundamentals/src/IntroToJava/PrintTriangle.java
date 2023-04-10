package IntroToJava;

import java.util.Scanner;

public class PrintTriangle {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        printTriangle(n);
    }

    //PRINT LINES:
    static void printTriangle(int n) {
        // first part
        for (int row = 1; row <= n; row++) {
            printLine(row);
        }
        //second part
        for (int row = n - 1; row >= 1; row--) {
            printLine(row);
        }
    }

    //PRINT COLUM:
    static void printLine(int end) {
        for (int i = 1; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

