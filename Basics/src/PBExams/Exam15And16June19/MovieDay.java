package PBExams.Exam15And16June19;

import java.util.Scanner;

public class MovieDay {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int timeForFilming = Integer.parseInt(scanner.nextLine());
        int scenes = Integer.parseInt(scanner.nextLine());
        int timeForScene = Integer.parseInt(scanner.nextLine());

        double preparationTime = timeForFilming * 0.15;
        double shootingTime = scenes * timeForScene;
        double totalTime = preparationTime + shootingTime;

        if (totalTime > timeForFilming) {
            double needTime = Math.round(totalTime - timeForFilming);
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.", needTime);
        } else {
            System.out.printf("You managed to finish the movie on time! You have %.0f minutes left!", timeForFilming - totalTime);
        }
    }
}
