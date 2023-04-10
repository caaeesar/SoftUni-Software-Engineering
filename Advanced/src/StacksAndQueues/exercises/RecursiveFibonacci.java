package StacksAndQueues.exercises;

import java.util.Scanner;

public class RecursiveFibonacci {
    private static long[] fibonacciCache;

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        fibonacciCache = new long[n + 1]; // защото поредицата на фибонаци започва от нула
        long result = getFibonacci(n);
        System.out.println(result);
    }

    // 0  1  2  3  4  5  6  7   8   9   nthFibonacciNumber
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34  fibonacciNumber

    private static long getFibonacci(int n) {
        if (n < 2) {
            return 1;
        }

        if (fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }

        long nthFibonacciNumber = getFibonacci(n - 1) + getFibonacci(n - 2);
        fibonacciCache[n] = nthFibonacciNumber;

        return nthFibonacciNumber;
    }
}
