package Basic.exercise;

import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int currentNumber = start; currentNumber <= end; currentNumber++) {
            System.out.print(currentNumber + " ");
            sum += currentNumber;
        }
        System.out.println();
        System.out.printf("Sum: %d", sum);
    }
}
