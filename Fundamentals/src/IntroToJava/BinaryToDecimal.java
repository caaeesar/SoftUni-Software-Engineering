package IntroToJava;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        long binaryNumber = Long.parseLong(scanner.nextLine());
        int decimalNumber = 0;
        int pow = 0;

        while (binaryNumber != 0) {

            long lastNumber = binaryNumber % 10;

            double power = Math.pow(2, pow);
            double currentResult = lastNumber * power;
            decimalNumber += currentResult;
            pow++;

            binaryNumber /= 10;
        }
        System.out.println(decimalNumber);
    }
}
