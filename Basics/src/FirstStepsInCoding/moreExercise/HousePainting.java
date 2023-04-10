package FirstStepsInCoding.moreExercise;

import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        // wall - green paint ( 1 l for 3.4 m2) ; roof - red paint (1 l for 4.3 m2)

        double x = Double.parseDouble(scan.nextLine());    // височина
        double y = Double.parseDouble(scan.nextLine());   // дължина
        double h = Double.parseDouble(scan.nextLine());  // височина

        // m2 / l for paint = result

        double frontWall = (x * x) - (1.2 * 2);  //  минус вратата
        double rearWall = x * x;
        double walls = frontWall + rearWall;

        double sideWalls = (2 * (x * y)) - (Math.pow(1.5,2) * 2); // махаме прозорците

        double roofRec = 2 * (x * y);
        double roofTr = (2 * (x * h/ 2));

        double greenPaint = (walls + sideWalls) / 3.4;
        double redPaint = (roofRec + roofTr) / 4.3;

        System.out.printf("%.2f%n%.2f",greenPaint,redPaint);
    }
}
