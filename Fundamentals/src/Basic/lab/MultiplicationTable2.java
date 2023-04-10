package Basic.lab;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());

        // int times = Integer.parseInt(scanner.nextLine());
       /* if (times > 10) {
            System.out.printf("%d X %d = %d", number, times, number * times);
        }

        for (int multiplier = end; multiplier <= 10; multiplier++) {
            System.out.printf("%d X %d = %d%n", number, multiplier, number * multiplier);
        }*/

        do {
            System.out.printf("%d X %d = %d", number, multiplier, number * multiplier);
            multiplier++;
        } while (multiplier <= 10);


    }
}
