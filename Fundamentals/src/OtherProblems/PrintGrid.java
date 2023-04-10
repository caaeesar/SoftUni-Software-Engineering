package OtherProblems;

import java.util.Scanner;

public class PrintGrid {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

    /*    int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());*/

        int[][] arr = new int[10][10];
        int size = arr.length;
        System.out.println(size);

        int x = 1;
        for (int r = 0; r < arr.length ; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                arr[r][c] = x;
                System.out.print(arr[r][c]);
            }
                x++;
            System.out.println();
        }
    }
}
