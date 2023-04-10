package JavaBook;

import java.util.Scanner;

public class TwoDRectangleArea {
    public static void main(String[] arguments) {

        //НЕ РЕШЕНА
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double length = Math.abs(Math.max(x1,x2) - Math.min(x1,x2));
        double weight = Math.abs(Math.max(y1,y2) - Math.min(y1,y2));

        double area = Math.abs(length * weight);
        double perimeter = 2 * (length + weight);

        System.out.printf("%f%n", area);
        System.out.printf("%f", perimeter);
    }
}
