package Methods.lab;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());
        double area = getArea(width,length);
        System.out.printf("%.0f", area);
    }

    static double getArea(double width, double length) {
        return width * length;
    }
}
