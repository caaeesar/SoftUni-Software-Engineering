package Methods.moreExercise;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        //todo 80/100 !!
        // Питагорово разстояние -> формула
        // Euclidean distance

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        double point1 = distance(x1, y1);
        double point2 = distance(x2, y2);
        double point3 = distance(x3, y3);
        double point4 = distance(x4, y4);

        double line1Length = getLineLength(point1,point2);
        double line2Length = getLineLength(point3,point4);

        if (line1Length >= line2Length) {
            printLongerLine(x1,y1,x2,y2);
        } else {
            printLongerLine(x3,y3,x4,y4);
        }
    }

    private static double getLineLength(double p1, double p2) {
        double diff = Math.abs(p1 - p2);
        return Math.sqrt(Math.pow(diff, 2));
    }

    private static double distance(double x, double y) {
        return x + y;
    }

    private static void printLongerLine(double x, double y, double p, double q) {

        double distance1 = Math.abs(x + y);
        double distance2 = Math.abs(p + q);

        if (distance1 <= distance2) {
            System.out.printf("(%.0f, %.0f)", x, y);
            System.out.printf("(%.0f, %.0f)", p, q);
        } else {
            System.out.printf("(%.0f, %.0f)", p, q);
            System.out.printf("(%.0f, %.0f)", x, y);
        }
    }
}
