package JavaBook;

import java.util.Scanner;

public class PointOnRectangleBorder {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        //в кординатната сисътема числата нарастват отляво надясно и отгоре надолу;
        // x1 и x2 - дължината на правоъгълника;
        // y1 и y2 - ширината на правоъгълника;

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

          // точката ще лежи на някоя страна ако:
         // x съвпада с x1 или x2 и същевременно y е между y1 и y2;
        // y съвпада с y1 или y2 и същевременно x е между x1 и x2;

        if ((x == x1 || x == x2) && (y >= y1 && y <= y2)) { // точката ще лежи на ширината;
            System.out.println("Border");
        } else if ((y == y1 || y == y2) && (x >= x1 && x <= x2)) { // точката ще лежи на дължината;
            System.out.println("Border");
        } else {
            System.out.println("Inside / Outside");
        }
    }
}
