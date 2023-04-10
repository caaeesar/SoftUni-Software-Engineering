package JavaBook.ExamPreparationPart1;

import java.util.Scanner;

public class PerfectDiamond {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        if (n == 1) {
            System.out.println("*");
        } else {

        // първия и последния ред:
        int countSpace = n - 1;
        String space = repeatString(" ", countSpace);
        String firstLastRow = space + "*";
        System.out.println(firstLastRow);

        // първа част:
        int countStarDash = 1;

        for (int row = 1; row <= n - 1; row++) {
            countSpace--;
            String starDash = repeatString("-*", countStarDash);
            String midSpace = repeatString(" ", countSpace);
            String currentRow = midSpace + "*" + starDash;
            countStarDash++;
            System.out.println(currentRow);
        }
        // втора част:
        countStarDash -= 1;
        for (int row = 1; row <= n - 2; row++) {
            countStarDash--;
            countSpace++;
            String starDash = repeatString("-*", countStarDash);
            String midSpace = repeatString(" ", countSpace);
            String currentRow = midSpace + "*" + starDash;
            System.out.println(currentRow);
        }
        System.out.println(firstLastRow);
    }
        }


    static String repeatString(String str, int count) {
        StringBuilder text = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            text.append(str);
        }
        return text.toString();
    }
}
