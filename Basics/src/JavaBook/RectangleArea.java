package JavaBook;

import java.text.DecimalFormat;
import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double weight = Math.max(y1,y2) - Math.min(y1,y2);
        double length = Math.max(x1,x2) - Math.min(x1,x2);

        double area = weight * length;
        double perimeter = 2 * (weight + length);

        DecimalFormat decimalFormat = new DecimalFormat("#.########");

        System.out.println(decimalFormat.format(area));
        System.out.println(decimalFormat.format(perimeter));
    }
}
