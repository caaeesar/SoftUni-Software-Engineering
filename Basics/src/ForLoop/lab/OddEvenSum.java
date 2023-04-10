package ForLoop.lab;

import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int oddSum = 0;
        int evenSum = 0;

        for (int position = 1; position <= n; position++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (position % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }
        }
        if (oddSum == evenSum) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", oddSum);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(oddSum - evenSum));
        }
    }
}


