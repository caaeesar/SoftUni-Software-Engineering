package WhileLoop.moreExercise;

import java.util.Scanner;

public class AverageNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int sum = 0;


        while (n != count) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            sum += currentNumber;
            ++count;
        }
        System.out.printf("%.2f", sum * 1.00 / count);
    }
}
