package JavaBook;

import java.util.Scanner;

public class PointInRectangle {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

          //в кординатната сисъема числата нарастват отляво надясно и отгоре надолу;
         // x1 и x2 - дължината на правоъгълника;
        // y1 и y2 - ширината на правоъгълника;

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

          // за да е вътрешна точката:                  // за да е външна точката:
         // x трябва да е между x1 и x2;               //  x трябва да е > или x трябва да е < от x1 и x2;
        // y трябва да е между y1 и y2;               //  y трябва да е > или y трябва да е < от y1 и y2;

        if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
            System.out.println("Inside");
        } else if ((x < x1 || x > x2) || (y > y1 || y < y2)) {
            System.out.println("Outside");
        }
    }
}