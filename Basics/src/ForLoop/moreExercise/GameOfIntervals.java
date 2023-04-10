package ForLoop.moreExercise;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int play = Integer.parseInt(scanner.nextLine());
        double gameResult = 0.00;
        double point = 0.00;
        double count1 = 0.00;
        double count2 = 0.00;
        double count3 = 0.00;
        double count4 = 0.00;
        double count5 = 0.00;
        double count6 = 0.00;

        for (int i = 1; i <= play; i++) {

            int currentNum = Integer.parseInt(scanner.nextLine());

            if (currentNum >= 0 && currentNum <= 9) {
                point = currentNum * 0.2;
                gameResult += point;
                ++count1;
            } else if (currentNum >= 10 && currentNum <= 19) {
                point = currentNum * 0.3;
                gameResult += point;
                ++count2;
            } else if (currentNum >= 20 && currentNum <= 29) {
                point = currentNum * 0.4;
                gameResult += point;
                ++count3;
            } else if (currentNum >= 30 && currentNum <= 39) {
                point = 50;
                gameResult += point;
                ++count4;
            } else if (currentNum >= 40 && currentNum <= 50) {
                point = 100;
                gameResult += point;
                ++count5;
            } else {
                gameResult /= 2;
                ++count6;
            }
        }

        double percent1 = (count1 / play) * 100;
        double percent2 = (count2 / play) * 100;
        double percent3 = (count3 / play) * 100;
        double percent4 = (count4 / play) * 100;
        double percent5 = (count5 / play) * 100;
        double percent6 = (count6 / play) * 100;

        //  System.out.printf("%1$.2f\n%2$.2f%%\n%3$.2f%%\n%4$.2f%%\n%5$.2f%%\n%6$.2f%%\n%7$.2f%%", gameResult, percent1, percent2, percent3, percent4, percent5, percent6);
        System.out.printf("%.2f\n", gameResult);
        System.out.printf("From 0 to 9: %.2f%%\n", percent1);
        System.out.printf("From 10 to 19: %.2f%%\n", percent2);
        System.out.printf("From 20 to 29: %.2f%%\n", percent3);
        System.out.printf("From 30 to 39: %.2f%%\n", percent4);
        System.out.printf("From 40 to 50: %.2f%%\n", percent5);
        System.out.printf("Invalid numbers: %.2f%%", percent6);
    }
}
