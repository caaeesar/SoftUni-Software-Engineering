package ForLoop.exercise;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double count1 = 0.00;
        double count2 = 0.00;
        double count3 = 0.00;
        double count4 = 0.00;
        double count5 = 0.00;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number < 200) {
                ++count1;
            } else if (number < 400) { // number >= 200 && .. (подразбира се в else if-a)
                ++count2;
            } else if (number < 600) { // number >= 400 ..
                ++count3;
            } else if (number < 800) {
                ++count4;
            } else {
                ++count5;
            }
        }
        double percent1 = (count1 / n) * 100;
        double percent2 = (count2 / n) * 100;
        double percent3 = (count3 / n) * 100;
        double percent4 = (count4 / n) * 100;
        double percent5 = (count5 / n) * 100;

        System.out.printf("%.2f%%\n", percent1);
        System.out.printf("%.2f%%\n", percent2);
        System.out.printf("%.2f%%\n", percent3);
        System.out.printf("%.2f%%\n", percent4);
        System.out.printf("%.2f%%", percent5);
    }
}
