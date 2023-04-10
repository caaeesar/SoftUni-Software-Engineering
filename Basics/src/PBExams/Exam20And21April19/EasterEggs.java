package PBExams.Exam20And21April19;

import java.util.Scanner;

public class EasterEggs {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int allEggs = Integer.parseInt(scanner.nextLine());
        int redEggs = 0;
        int orangeEggs = 0;
        int blueEggs = 0;
        int greenEggs = 0;

        for (int currentEgg = 1; currentEgg <= allEggs; currentEgg++) {

            String currentColor = scanner.nextLine();

            switch (currentColor) {

                case "red":
                    redEggs++;
                    break;
                case "orange":
                    orangeEggs++;
                    break;
                case "blue":
                    blueEggs++;
                    break;
                case "green":
                    greenEggs++;
                    break;
            }
        }
        String maxColor = "";
        int maxEggs = 0;

        if (redEggs > orangeEggs && redEggs > blueEggs && redEggs > greenEggs) {
            maxColor = "red";
            maxEggs = redEggs;
        } else if (orangeEggs > redEggs && orangeEggs > blueEggs && orangeEggs > greenEggs) {
            maxColor = "orange";
            maxEggs = orangeEggs;
        } else if (blueEggs > redEggs && blueEggs > orangeEggs && blueEggs > greenEggs) {
            maxColor = "blue";
            maxEggs = blueEggs;
        } else if (greenEggs > redEggs && greenEggs > orangeEggs && greenEggs > blueEggs) {
            maxColor = "green";
            maxEggs = greenEggs;
        }
        System.out.printf("Red eggs: %d%n", redEggs);
        System.out.printf("Orange eggs: %d%n", orangeEggs);
        System.out.printf("Blue eggs: %d%n", blueEggs);
        System.out.printf("Green eggs: %d%n", greenEggs);
        System.out.printf("Max eggs: %d -> %s", maxEggs, maxColor);
    }
}
