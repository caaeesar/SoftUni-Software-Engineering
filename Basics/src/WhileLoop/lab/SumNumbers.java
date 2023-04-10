package WhileLoop.lab;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (sum < input) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            sum += currentNumber;
        }
        System.out.println(sum);
    }
}
