package PBExams.Exam15And16June19;

import java.util.Scanner;

public class SeriesCalculator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        int seasons = Integer.parseInt(scanner.nextLine());
        int episodes = Integer.parseInt(scanner.nextLine());
        double timeWithOutAd = Double.parseDouble(scanner.nextLine());

        double timeWithAd = timeWithOutAd * 0.2;
        double timeFor1Episode = timeWithOutAd + timeWithAd;
        double extraTime = seasons * 10;
        double totalTime = (timeFor1Episode * episodes) * seasons + extraTime;
        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", movie, Math.floor(totalTime));
    }
}
