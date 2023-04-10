package ConditionalStatements.exercise;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 1 мин. = 60 сек.

        int firstPlayer = Integer.parseInt(scan.nextLine());
        int secondPlayer = Integer.parseInt(scan.nextLine());
        int thirdPlayer = Integer.parseInt(scan.nextLine());

        int totalTime = firstPlayer + secondPlayer + thirdPlayer;
        int min = 0;
        int sec = 0;

        if (totalTime >= 60) {
            min = totalTime / 60;         //целочислено деление
            sec = totalTime % 60;
            System.out.printf("%d:%02d",min,sec); // 0%d => печата с 0 отпред
        } else {  // totalTime < 60
            sec = totalTime;
            System.out.printf("%d:%02d",min,sec);
        }
    }
}
