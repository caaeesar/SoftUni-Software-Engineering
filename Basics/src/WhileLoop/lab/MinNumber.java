package WhileLoop.lab;

import java.util.Scanner;

public class MinNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int minNumber = Integer.MAX_VALUE;

        while (!input.equals("Stop")) {
            int currentNum = Integer.parseInt(input);

            if (currentNum < minNumber) {
                minNumber = currentNum;
            }
            input = scanner.nextLine();
        }
        System.out.println(minNumber);
    }
}
