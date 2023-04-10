package JavaBook;

import java.util.Scanner;

public class Division {
    public static void main(String[] argument) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double count1 = 0.00;
        double count2 = 0.00;
        double count3 = 0.00;

        for (int i = 1; i <= n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());

            if (currentNumber % 2 == 0) {
                ++count1;
            }
            if (currentNumber % 3 == 0) {
                ++count2;
            }
            if (currentNumber % 4 == 0) {
                ++count3;
            }
        }
        double percent1 = (count1 / n) * 100;
        double percent2 = (count2 / n) * 100;
        double percent3 = (count3 / n) * 100;

        System.out.printf("%.2f%%\n", percent1);
        System.out.printf("%.2f%%\n", percent2);
        System.out.printf("%.2f%%", percent3);
    }
}
