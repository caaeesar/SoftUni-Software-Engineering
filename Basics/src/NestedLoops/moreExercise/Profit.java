package NestedLoops.moreExercise;

import java.util.Scanner;

public class Profit {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int count1 = Integer.parseInt(scanner.nextLine());
        int count2 = Integer.parseInt(scanner.nextLine());
        int count5 = Integer.parseInt(scanner.nextLine());
        int sum = Integer.parseInt(scanner.nextLine());

        for (int counter1 = 0; counter1 <= count1; counter1++) {

            for (int counter2 = 0; counter2 <= count2; counter2++) {

                for (int counter5 = 0; counter5 <= count5; counter5++) {

                    boolean isEqual = ((counter1 * 1) + (counter2 * 2) + (counter5 * 5) == sum);

                    if (isEqual) {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.\n", counter1, counter2, counter5, sum);
                    }
                }
            }
        }
    }
}
