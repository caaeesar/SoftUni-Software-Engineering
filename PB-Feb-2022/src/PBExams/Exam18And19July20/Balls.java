package PBExams.Exam18And19July20;

import java.util.Scanner;

public class Balls {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int totalBalls = Integer.parseInt(scanner.nextLine());
        double points = 0.00;
        int redBalls = 0;
        int orangeBalls = 0;
        int yellowBalls = 0;
        int whiteBalls = 0;
        int backBalls = 0;
        int otherColour = 0;

        for (int currentBall = 1; currentBall <= totalBalls; currentBall++) {

            String colour = scanner.nextLine();

            switch (colour) {

                case "red":
                    points += 5;
                    redBalls++;
                    break;
                case "orange":
                    points += 10;
                    orangeBalls++;
                    break;
                case "yellow":
                    points += 15;
                    yellowBalls++;
                    break;
                case "white":
                    points += 20;
                    whiteBalls++;
                    break;
                case "black":
                    points = Math.floor(points / 2);
                    backBalls++;
                    break;
                default:
                    otherColour++;
                    break;
            }
        }
        System.out.printf("Total points: %.0f%n", points);
        System.out.printf("Red balls: %d%n", redBalls);
        System.out.printf("Orange balls: %d%n", orangeBalls);
        System.out.printf("Yellow balls: %d%n", yellowBalls);
        System.out.printf("White balls: %d%n", whiteBalls);
        System.out.printf("Other colors picked: %d%n", otherColour);
        System.out.printf("Divides from black balls: %d", backBalls);
    }
}
