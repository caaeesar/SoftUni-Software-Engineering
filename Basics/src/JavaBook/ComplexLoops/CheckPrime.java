package JavaBook.ComplexLoops;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        boolean isPrime = number >= 2;

        for (int divider = 2; divider < number; divider++) {

            if (number % divider == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println("Prime");
        } else {
            System.out.println("Not prime");
        }
    }
}
