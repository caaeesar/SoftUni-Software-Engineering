package ConditionalStatements.exercise;

import java.util.Scanner;

public class Time15Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputHours = Integer.parseInt(scan.nextLine());
        int inputMin = Integer.parseInt(scan.nextLine());

        int totalMin = (inputHours * 60) + inputMin; // превръщаме часовете в мин.
        int addTime = totalMin + 15;
        int hours = addTime / 60;     // получаваме часовете
        int minutes = addTime % 60;  // получаваме минутите

        if (hours > 23) {
            hours = 0;
        }
        if (minutes < 10) {
            System.out.printf("%d:%02d", hours, minutes);
        } else {
            System.out.printf("%d:%d", hours, minutes);
        }
    }
}
