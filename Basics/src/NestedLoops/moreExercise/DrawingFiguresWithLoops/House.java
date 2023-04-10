package NestedLoops.moreExercise.DrawingFiguresWithLoops;

import java.util.Scanner;

public class House {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int countStars = 0;
        if (n % 2 == 0) {
            countStars = 2;
        } else {
            countStars = 1;
        }

        // покрива:
        for (int row = 1; row <= Math.ceil(n / 2.00); row++) {

            String underscore = repeatString("-", (n - countStars) / 2);
            String stars = repeatString("*", countStars);
            String currentRow = underscore + stars + underscore;
            System.out.println(currentRow);
            countStars += 2;
        }

        // основата:
        for (int row = 1; row <= n - Math.ceil(n / 2.00); row++) {

            String stars = repeatString("*", n - 2);
            String currentRow = "|" + stars + "|";
            System.out.println(currentRow);
        }
    }

    static String repeatString(String str, int count) {
        String text = "";
        for (int i = 1; i <= count; i++) {
            text += str;
        }
        return text;
    }
}
