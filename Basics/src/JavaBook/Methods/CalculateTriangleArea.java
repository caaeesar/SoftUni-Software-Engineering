package JavaBook.Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculateTriangleArea {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        DecimalFormat format = new DecimalFormat("#.############");
        double side = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double area = sumArea(side,height);
        System.out.print(format.format(area));
    }

    static double sumArea(double a, double h) {

        return (a * h) / 2.00;
    }
}
