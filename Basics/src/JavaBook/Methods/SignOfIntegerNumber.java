package JavaBook.Methods;

import java.util.Scanner;

public class SignOfIntegerNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        printSign(input);
    }

    static void printSign(int number) {

        if (number > 0) {
            System.out.printf("The number %d is positive.", number);
        } else if (number < 0) {
            System.out.printf("The number %d is negative.", number);
        } else {
            System.out.print("The number 0 is zero.");
        }
    }
}
