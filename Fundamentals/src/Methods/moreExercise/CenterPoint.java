package Methods.moreExercise;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        findClosestPoint(x1, y1, x2, y2);
    }

   private static void findClosestPoint(double x1, double y1, double x2, double y2) {

        double distance1 = x1 + y1;
        double distance2 = x2 + y2;

        if (distance1 < distance2) {
            System.out.printf("(%.0f, %.0f)", x1, y1);
        } else {
            System.out.printf("(%.0f, %.0f)", x2, y2);
        }
    }
}
