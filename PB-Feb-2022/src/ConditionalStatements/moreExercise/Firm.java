package ConditionalStatements.moreExercise;

import java.util.Scanner;

public class Firm {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int projectHour = Integer.parseInt(scanner.nextLine()); // необходимите часове за проекта
        int haveDay = Integer.parseInt(scanner.nextLine());  // броят на дните, с които фирмата разполага
        int countWorker = Integer.parseInt(scanner.nextLine()); //броят на служителите работещи извънредно
                                                                // 2 часа на ден

        double timeEducation = haveDay * 0.10;
        double leftTime = haveDay - timeEducation;
        double hoursInWork = leftTime * 8;  // 8 часов работен ден
        double hoursInHome = countWorker * 2 * haveDay;

        double totalHours = Math.floor(hoursInHome + hoursInWork);

        boolean isEnough = totalHours >= projectHour; //времето е достатъчно
        if (isEnough) {
            System.out.printf("Yes!%.0f hours left.", totalHours - projectHour);
        } else {
           // System.out.printf("Not enough time!%.0f hours needed.", projectHour - totalHours);
             System.out.printf("Not enough time!%d hours needed.", (int) (projectHour - totalHours)); //кастване към int
        }
    }
}
