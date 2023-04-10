package Arrays.moreExercise;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int height = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < height; row++) {

            int number = 1;

            for (int col = 0; col <= row; col++) {

                System.out.print(number + " ");
                number = (number * (row - col)) / (col + 1);
            }
            System.out.println();
        }
    }
}
