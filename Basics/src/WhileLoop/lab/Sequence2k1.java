package WhileLoop.lab;

import java.util.Scanner;

public class Sequence2k1 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int currentNumber = 1;

        while (currentNumber <= n) {
            System.out.println(currentNumber);
            currentNumber = (currentNumber * 2) + 1;
        }
    }
}
