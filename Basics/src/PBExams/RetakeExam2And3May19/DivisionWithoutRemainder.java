package PBExams.RetakeExam2And3May19;

import java.util.Scanner;

public class DivisionWithoutRemainder {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double p1 = 0.00;
        double p2 = 0.00;
        double p3 = 0.00;

        for (int number = 1; number <= n; number++) {

            int currentNumber = Integer.parseInt(scanner.nextLine());

            if (currentNumber % 2 == 0) {
                p1++;
            }
            if (currentNumber % 3 == 0) {
                p2++;
            }
            if (currentNumber % 4 == 0) {
                p3++;
            }
        }

        double percent1 = (p1 / n) * 100;
        double percent2 = (p2 / n) * 100;
        double percent3 = (p3 / n) * 100;

        System.out.printf("%.2f%%%n", percent1);
        System.out.printf("%.2f%%%n", percent2);
        System.out.printf("%.2f%%", percent3);

    }
}
