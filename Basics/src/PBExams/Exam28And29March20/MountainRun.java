package PBExams.Exam28And29March20;

import java.util.Scanner;

public class MountainRun {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double distanceInMeters = Double.parseDouble(scanner.nextLine());
        double timeFor1Meter = Double.parseDouble(scanner.nextLine()); // in seconds

        double climbingTime = distanceInMeters * timeFor1Meter;
        // дистанцията / 50 -> получаваме колко пъти в това разстояние се събират 50 м;
        // и след това умножаваме пътите, в които се забавя по секундите;
        double slope = Math.floor((distanceInMeters / 50)) * 30;
        double totalHisSec = climbingTime + slope; // добавяме забавянето, защото то увеличава неговото време

        if (totalHisSec >= recordInSeconds) {

            System.out.printf("No! He was %.2f seconds slower.", totalHisSec - recordInSeconds);
        } else {

            System.out.printf("Yes! The new record is %.2f seconds.", totalHisSec);
        }
    }
}
