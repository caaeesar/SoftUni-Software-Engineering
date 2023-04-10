package Arrays.moreExercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.print(fib(n));
    }

    static long fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
        /* f(5) = f(4) + f(3)
           f(4) = f(3) + f(2)
           f(3) = f(3) + f(1)
         */
    }
}
