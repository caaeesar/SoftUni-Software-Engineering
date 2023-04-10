package TextProcessing.exercise;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine().trim();
        int multiplier = Integer.parseInt(scanner.nextLine());
        int remainder = 0;
        StringBuilder result = new StringBuilder();

        // input -> 00005 / 2303
        for (int i = 0; i < number.length(); i++) {
            char symbol = number.charAt(i);
            if (symbol != '0') {
                number = number.substring(i);
                break;
            }
        }

        if (number.isEmpty()) {
            number = "0";
        }
        if (multiplier == 0) {
            System.out.println("0");
            return;
        }

        for (int index = number.length() - 1; index >= 0; index--) {

            char currentNum = number.charAt(index);
            int totalSum = Integer.parseInt(currentNum + "") * multiplier;
            totalSum += remainder;
            result.append(totalSum % 10);
            remainder = totalSum / 10;
        }

        if (remainder > 0) {
            result.append(remainder);
        }
        System.out.println(result.reverse());
    }
}
