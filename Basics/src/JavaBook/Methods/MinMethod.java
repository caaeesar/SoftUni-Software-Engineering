package JavaBook.Methods;

import java.util.Scanner;

public class MinMethod {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());
        System.out.print(getMin(number1,number2,number3));
    }

    static int getMin(int number1, int number2, int number3) {

        int min = Integer.MAX_VALUE;

        if (number1 < min) {
            min = number1;
        }
        if (number2 < min) {
            min = number2;
        }
        if (number3 < min) {
            min = number3;
        }
        return min;
    }
}
