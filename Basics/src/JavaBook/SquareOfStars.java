package JavaBook;

import java.util.Scanner;

public class SquareOfStars {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int rows = 1; rows <= input; rows++) {
            System.out.println();
            for (int cols = 1; cols <= input; cols++) {

                if (rows != 1 && rows != input && cols != 1 && cols != input) {

                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
        }
    }
}
