package ConditionalStatementsAdvanced.exercise;

import java.util.Scanner;

public class OnTimeForExam {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMin = Integer.parseInt(scanner.nextLine());
        int arriveHour = Integer.parseInt(scanner.nextLine());
        int arriveMin = Integer.parseInt(scanner.nextLine());

             // превръщаме всичко в мин
        int totalExMin = examHour * 60 + examMin;
        int totalArrMin = arriveHour * 60 + arriveMin;

        if (totalArrMin > totalExMin) { // закъсняли сме

            int lateTime = totalArrMin - totalExMin;  // откриваме времето, с което сме закъсняли
            if (lateTime < 60) {   // закъсняли сме с минути
                int lateMin = lateTime % 60;   // намираме минутите
                System.out.printf("Late%n%d minutes after the start",lateMin);
            } else { // закъсняли сме с час (и мин)
                int lateHour = lateTime / 60;   // намираме часа
                int lateMin = lateTime % 60;   // намираме минутите
                System.out.printf("Late%n%d:%02d hours after the start",lateHour,lateMin);
            }
        } else if (totalArrMin == totalExMin) { // дошли сме точно навреме
            System.out.print("On time");
        } else if (totalExMin - totalArrMin <= 30) {  // до 30 мин. по-рано
            int earlyTime = totalExMin - totalArrMin;
            System.out.printf("On time%n%d minutes before the start",earlyTime);
        } else if (totalExMin - totalArrMin > 30) { // подранява повече от 30 мин

            int earlyTime = totalExMin - totalArrMin;
            if (earlyTime < 60) { //закъсняли сме с минути
                int earlyMin = earlyTime % 60;
                System.out.printf("Early%n%d minutes before the start",earlyMin);
            } else { // закъсняли сме с час (и мин)

                int earlyHour = earlyTime / 60;
                int earlyMin = earlyTime % 60;
                System.out.printf("Early%n%d:%02d hours before the start",earlyHour,earlyMin);
            }
        }
    }
}
