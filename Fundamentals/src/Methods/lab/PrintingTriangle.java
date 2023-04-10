package Methods.lab;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 1; row <= n; row++) {

            for (int col = 1; col <= row; col++) {

                System.out.printf("%d ", col);
            }
            System.out.println();
        }
        for (int row = n - 1; row >=  1; row--) {

            for (int col = 1; col <= row; col++) {

                System.out.printf("%d ", col);
            }
            System.out.println();
        }
    }
}
