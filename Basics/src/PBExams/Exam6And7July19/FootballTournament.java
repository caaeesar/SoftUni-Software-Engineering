package PBExams.Exam6And7July19;

import java.util.Scanner;

public class FootballTournament {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String team = scanner.nextLine();
        int allMatches = Integer.parseInt(scanner.nextLine());

        if (allMatches == 0) {
            System.out.printf("%s hasn't played any games during this season.", team);
            return;
        }

        double countWin = 0.00;
        int countDraw = 0;
        int countLost = 0;
        double point = 0.00;

        for (int match = 1; match <= allMatches; match++) {

            String currentResult = scanner.nextLine();

            switch (currentResult) {

                case "W":
                    countWin++;
                    point += 3;
                    break;
                case "D":
                    countDraw++;
                    point += 1;
                    break;
                case "L":
                    countLost++;
                    break;
            }
        }

        System.out.printf("%s has won %.0f points during this season.%n", team, point);
        System.out.println("Total stats:");
        System.out.printf("## W: %.0f%n", countWin);
        System.out.printf("## D: %d%n", countDraw);
        System.out.printf("## L: %d%n", countLost);

        double percentWin = (countWin / allMatches) * 100;
        System.out.printf("Win rate: %.2f%%", percentWin);

    }
}
