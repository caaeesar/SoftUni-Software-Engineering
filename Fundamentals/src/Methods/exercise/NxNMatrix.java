package Methods.exercise;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }
    }
}
