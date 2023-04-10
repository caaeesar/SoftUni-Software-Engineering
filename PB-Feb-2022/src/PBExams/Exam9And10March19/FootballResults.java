package PBExams.Exam9And10March19;

import java.util.Scanner;

public class FootballResults {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int win = 0;
        int lost = 0;
        int draw = 0;

        for (int currentMatch = 1; currentMatch <= 3; currentMatch++) {

            String currentResult = scanner.nextLine();

            char result1 = currentResult.charAt(0);
            char result2 = currentResult.charAt(2);

            int firstScore = Integer.parseInt(result1 + "");
            int secondScore = Integer.parseInt(result2 + "");

            if (firstScore > secondScore) {
                win++;
            } else if (firstScore < secondScore) {
                lost++;
            } else {
                draw++;
            }
        }
        System.out.printf("Team won %d games.%n",win);
        System.out.printf("Team lost %d games.%n",lost);
        System.out.printf("Drawn games: %d",draw);
    }
}
