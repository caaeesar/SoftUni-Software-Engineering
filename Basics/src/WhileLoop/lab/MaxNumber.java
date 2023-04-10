package WhileLoop.lab;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int maxNum = Integer.MIN_VALUE;

        while (!input.equals("Stop")) {
            int currentNumber = Integer.parseInt(input);

            if (currentNumber > maxNum) {
                maxNum = currentNumber;
            }
            input = scanner.nextLine();
        }
        System.out.println(maxNum);
    }
}
