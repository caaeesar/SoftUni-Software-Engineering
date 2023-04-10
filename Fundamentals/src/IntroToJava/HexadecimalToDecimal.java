package IntroToJava;

import java.util.Scanner;

public class HexadecimalToDecimal {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String hexNumber = scanner.nextLine();
        int pow = 0;
        int digit = 0;
        double decimal = 0.00;

        for (int position = hexNumber.length() - 1; position >= 0; position--) {

            char symbol = hexNumber.charAt(position);

            switch (symbol) {

                case 'A':
                    digit = 10;
                    break;
                case 'B':
                    digit = 11;
                    break;
                case 'C':
                    digit = 12;
                    break;
                case 'D':
                    digit = 13;
                    break;
                case 'E':
                    digit = 14;
                    break;
                case 'F':
                    digit = 15;
                    break;
                default:
                    digit = Integer.parseInt(symbol + "");
                    break;
            }
            double power = Math.pow(16, pow);
            double currentResult = digit * power;
            decimal += currentResult;
            pow++;
        }
        System.out.printf("%s(16) = %.0f(10)", hexNumber, decimal);
    }
}
