package ForLoop.moreExercise;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        int allFans = Integer.parseInt(scanner.nextLine());
        double countA = 0;
        double countB = 0;
        double countV = 0;
        double countG = 0;

        for (int fan = 1; fan <= allFans; fan++) {
            char sector = scanner.nextLine().charAt(0);

            switch (sector) {
                case 'A' -> ++countA;
                case 'B' -> ++countB;
                case 'V' -> ++countV;
                case 'G' -> ++countG;
            }
        }
        double percentA = (countA / allFans) * 100;
        double percentB = (countB / allFans) * 100;
        double percentV = (countV / allFans) * 100;
        double percentG = (countG / allFans) * 100;
        double percentOfFans = (allFans * 1.00 / capacity) * 100;

        System.out.printf("%.2f%%\n", percentA);
        System.out.printf("%.2f%%\n", percentB);
        System.out.printf("%.2f%%\n", percentV);
        System.out.printf("%.2f%%\n", percentG);
        System.out.printf("%.2f%%", percentOfFans);
    }
}
