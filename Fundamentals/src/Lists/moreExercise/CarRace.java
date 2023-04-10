package Lists.moreExercise;

import java.util.Scanner;

public class CarRace {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] totalTime = scanner.nextLine().split(" ");
        int[] leftPlayerTime = readLeftTime(totalTime);
        int[] rightPlayerTime = readRightTime(totalTime);

        double sumLeftTime = sumTime(leftPlayerTime);
        double sumRightTime = sumTime(rightPlayerTime);

        printWinner(sumLeftTime, sumRightTime);
    }

    private static void printWinner(double sumLeftTime, double sumRightTime) {
        if (sumLeftTime < sumRightTime) {
            System.out.printf("The winner is left with total time: %.1f",sumLeftTime);
        } else if (sumRightTime < sumLeftTime){
            System.out.printf("The winner is right with total time: %.1f",sumRightTime);
        }
    }

    private static double sumTime(int[] leftPlayerTime) {
        double totalTime = 0;
        for (int index = 0; index < leftPlayerTime.length; index++) {
            int currentTime = leftPlayerTime[index];
            totalTime += currentTime;
            if (currentTime == 0) {
                double reducedTime = totalTime * 0.2;
                totalTime -= reducedTime;
            }
        }
        return totalTime;
    }

    private static int[] readRightTime(String[] totalTime) {
        int[] playerTime = new int[totalTime.length / 2];
        int index = 0;
        for (int i = totalTime.length - 1; i >= (totalTime.length / 2) + 1; i--) {
            playerTime[index] = Integer.parseInt(totalTime[i]);
            index++;
        }
        return playerTime;
    }

    private static int[] readLeftTime(String[] totalTime) {
        int[] playerTime = new int[totalTime.length / 2];
        for (int i = 0; i < totalTime.length / 2; i++) {
            playerTime[i] = Integer.parseInt(totalTime[i]);
        }
        return playerTime;
    }
}
