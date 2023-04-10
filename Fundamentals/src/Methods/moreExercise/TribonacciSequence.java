package Methods.moreExercise;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int t0 = 0;
        int t1 = 0;
        int t2 = 1;
        System.out.print(1 + " ");

        for (int i = 1; i < n; i++) {

            int tn = t0 + t1 + t2;
            System.out.print(tn + " ");
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }
    }
}
