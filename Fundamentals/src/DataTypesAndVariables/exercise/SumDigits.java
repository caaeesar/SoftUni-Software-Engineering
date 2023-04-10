package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String numberToString = String.valueOf(number);
        int sum = 0;

        for (int position = 0; position < numberToString.length(); position++) {

            char digit = numberToString.charAt(position);
            int charToInt = Integer.parseInt(digit + "");
            sum += charToInt;
        }
        System.out.print(sum);

        /*
         * int number = Integer.parseInt(scanner.nextLine());
         *         int sum = 0;
         *
         *         while (number != 0){
         *
         *             int digit = number % 10;
         *             sum += digit;
         *             number /= 10;
         *         }
         *         System.out.println(sum);
         */
    }
}
