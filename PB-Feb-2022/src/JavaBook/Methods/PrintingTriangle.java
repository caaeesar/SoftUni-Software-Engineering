package JavaBook.Methods;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        doFirstPart(input);
        doSecondPart(input);
    }

    static void doFirstPart(int n) {

        for (int row = 1; row <= n; row++) {
            int currentNumber = 1;

            for (int colum = 1; colum <= row; colum++) {

                if (currentNumber == n) {
                    System.out.print(currentNumber + " ");
                    return;
                }
                System.out.print(currentNumber + " ");
                currentNumber++;

            }
            System.out.println();
        }
    }

    static void doSecondPart(int n) {

        int copyN = n;
        for (int row = 1; row <= n - 1; row++) {

            System.out.println();
            int currentNumber = 1;

            for (int colum = 1; colum < copyN; colum++) {

                System.out.print(currentNumber + " ");
                currentNumber++;
            }
            copyN--;
        }
    }
}
