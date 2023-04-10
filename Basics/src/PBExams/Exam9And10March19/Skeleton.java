package PBExams.Exam9And10March19;

import java.util.Scanner;

public class Skeleton {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int minControl = Integer.parseInt(scanner.nextLine());
        int secControl = Integer.parseInt(scanner.nextLine());
        double lengthM = Double.parseDouble(scanner.nextLine());
        int sec100M = Integer.parseInt(scanner.nextLine());

        int totalSecControl = (minControl * 60) + secControl;
        double timeDown = lengthM / 120;
        double totalTimeDown = timeDown * 2.5;
        double hisTime = ((lengthM / 100) * sec100M) - totalTimeDown;

        if (hisTime <= totalSecControl) {
            System.out.println("Marin Bangiev won an Olympic quota!");
            System.out.printf("His time is %.3f.", hisTime);
        } else {
            System.out.printf("No, Marin failed! He was %.3f second slower.", hisTime - totalSecControl);
        }
    }
}
