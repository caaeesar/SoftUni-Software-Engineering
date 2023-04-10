package JavaBook.ComplexLoops;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int sum = 0;

       do {
            int lastDigit = input % 10;
            sum += lastDigit;
            input /= 10;
        } while (input > 0);
       
        System.out.print(sum);

    }
}
