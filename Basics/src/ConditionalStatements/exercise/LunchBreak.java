package ConditionalStatements.exercise;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String movieName = scan.nextLine();
        int episodeDur = Integer.parseInt(scan.nextLine());
        int breakTime = Integer.parseInt(scan.nextLine());

       double lunchTime = breakTime / 8.00;
        double timeRest = breakTime / 4.00;

        double leftTime = breakTime - lunchTime - timeRest;
        boolean isEnough = leftTime >= episodeDur;

        if (isEnough) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.",movieName, Math.ceil(leftTime - episodeDur));
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", movieName, Math.ceil(episodeDur - leftTime));
        }
    }
}
