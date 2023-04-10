package Basic.lab;

import java.util.Scanner;

public class RefactorSumOfOddNumbers {
    public static void main(String[] arguments) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        int max = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i <= max; i += 2) {
            System.out.println(i);
            sum += i;
            count++;
            if (count == n) {
                break;
            }
        }
        System.out.printf("Sum: %d%n", sum);
    }
}
