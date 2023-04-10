package ForLoop.exercise;

import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int tournaments = Integer.parseInt(scanner.nextLine());
        int point = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int currentAveragePoint = 0;

        for (int i = 1; i <= tournaments; i++) {

            String position = scanner.nextLine();
            switch (position) {
                case "W":
                    currentAveragePoint += 2000;
                    point += 2000;
                    ++count;
                    break;
                case "F":
                    currentAveragePoint += 1200;
                    point += 1200;
                    break;
                case "SF":
                    currentAveragePoint += 720;
                    point += 720;
                    break;
            }
        }

        int averagePoint = currentAveragePoint / tournaments;
        double percentWin = (count * 1.00 / tournaments) * 100;

        System.out.printf("Final points: %d\n", point);
        System.out.printf("Average points: %.0f\n", Math.floor(averagePoint));
        System.out.printf("%.2f%%", percentWin);
    }
}
