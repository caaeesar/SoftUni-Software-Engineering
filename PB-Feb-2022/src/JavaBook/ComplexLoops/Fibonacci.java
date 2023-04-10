package JavaBook.ComplexLoops;

import java.util.Scanner;

public class  Fibonacci {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        // първите две числа от редицата на Фибоначи са 0 и 1
        // всяко следващо число е сбора от предходните две
        int n = Integer.parseInt(scanner.nextLine());
        int f0 = 0;
        int f1 = 1;
        int fn = 0;

        for (int i = 1; i <= n; i++) {

            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        System.out.println(fn);
    }
}
