package PBExams.Exam9And10March19;

import java.util.Scanner;

public class BasketballTournament {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String tournament = scanner.nextLine();
        double wins = 0.00;
        double fails = 0.00;
        int currentMatches = 0;
        int allMatches = 0;

        while (!"End of tournaments".equals(tournament)) {

            int matches = Integer.parseInt(scanner.nextLine());

            for (int currentMatch = 1; currentMatch <= matches; currentMatch++) {

                int firstTeamPoint = Integer.parseInt(scanner.nextLine());
                int secondTeamPoint = Integer.parseInt(scanner.nextLine());
                currentMatches++;
                allMatches++;

                if (firstTeamPoint > secondTeamPoint) {
                    wins++;
                    int diff = firstTeamPoint - secondTeamPoint;
                    System.out.printf("Game %d of tournament %s: win with %d points.%n", currentMatches, tournament, diff);
                } else {
                    fails++;
                    int diff = secondTeamPoint - firstTeamPoint;
                    System.out.printf("Game %d of tournament %s: lost with %d points.%n", currentMatches, tournament, diff);
                }
            }
            tournament = scanner.nextLine();
            currentMatches = 0;
        }
        double percentWin = (wins / allMatches) * 100;
        double percentLost = (fails / allMatches) * 100;
        System.out.printf("%.2f%% matches win%n", percentWin);
        System.out.printf("%.2f%% matches lost", percentLost);
    }
}
