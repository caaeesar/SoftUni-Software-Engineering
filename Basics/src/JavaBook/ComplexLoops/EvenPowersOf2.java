package JavaBook.ComplexLoops;

import java.util.Scanner;

public class EvenPowersOf2 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int power = 0; power <= n; power++) {

            if (power % 2 == 0) {
                double result = Math.pow(2,power);
                System.out.printf("%.0f%n", result);
            }
        }
    }
}
