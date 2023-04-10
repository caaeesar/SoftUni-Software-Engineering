package NestedLoops.moreExercise.DrawingFiguresWithLoops;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int countStars = 0;
        if (n % 2 == 0) {
            countStars = 2;
        } else {
            countStars = 1;
        }

        int rightLeft = (n - countStars) / 2;

        // първи ред:
        String firstHyphen = repeatString("-", rightLeft);
        String firstStar = repeatString("*", countStars);
        String firstLastRow = firstHyphen + firstStar + firstHyphen;
        System.out.println(firstLastRow);
        int middle = countStars;

        // ПЪРВА ЧАСТ:
        // формула => общия брой на редовете - първия,средния,последния / 2 (частите на фиг.)
        for (int row = 1; row <= (n - 3) / 2; row++) {

            rightLeft--;
            String hyphen = repeatString("-", rightLeft);
            String midHyphen = repeatString("-", middle);
            String insideRow = hyphen + "*" + midHyphen + "*" + hyphen;
            System.out.println(insideRow);
            middle += 2;
        }
        // СРЕДНА ЧАСТ:
        if (n > 2) { // при вход 1 или 2 -> няма средна и втора част;
            String hyphen3 = repeatString("-", n - 2);
            String midRow = "*" + hyphen3 + "*";
            System.out.println(midRow);

            // ВТОРА ЧАСТ:
            for (int row = 1; row <= (n - 3) / 2; row++) {

                middle -= 2;
                String hyphen4 = repeatString("-", rightLeft);
                String midHyphen = repeatString("-", middle);
                String insideRow = hyphen4 + "*" + midHyphen + "*" + hyphen4;
                rightLeft++;
                System.out.println(insideRow);
            }
            System.out.println(firstLastRow);
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
