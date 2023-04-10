package ConditionalStatements.moreExercise;

import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int restDays = Integer.parseInt(scan.nextLine()); //броят почивни дни
        int hisStandard = 30000; //минути на спане в година

                           // в почивните дни      // в работните дни
        int timeForGame = (restDays * 127) + ((365 - restDays) * 63);

        boolean asleep = hisStandard > timeForGame;
        if (asleep) {
            int lessPlay = hisStandard - timeForGame;
            int hour = lessPlay / 60;
            int min = lessPlay % 60;
            System.out.printf("Tom sleeps well%n%d hours and %d minutes less for play",hour,min);
        } else {
            int morePlay = timeForGame - hisStandard;
            int hour = morePlay / 60;
            int min = morePlay % 60;

            System.out.printf("Tom will run away%n%d hours and %d minutes more for play",hour,min);
        }
    }
}
