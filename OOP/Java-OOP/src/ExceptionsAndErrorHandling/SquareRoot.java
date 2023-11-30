package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            int number = Integer.parseInt(input);
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            double sqrt = Math.sqrt(number);
            System.out.printf("%.2f\n", sqrt);
        } catch (NumberFormatException e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }

    }
}
