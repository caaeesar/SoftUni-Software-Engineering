package JavaBook;

import java.util.Scanner;

public class PointInTheFigure {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
                                                           //   64 / 100 В ДЖЪДЖ
        int h = Integer.parseInt(scanner.nextLine());
        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());

        //кординати на долния правоъгълник:
        int x1 = 0;
        int y1 = 0;
        int x2 = 3 * h;
        int y2 = h;

        //кординати на горния правоъгълник:
        int x3 = h;
        int y3 = h;
        int x4 = 2 * h;
        int y4 = 4 * h;

        //точката ще е вътрешна за долния прав. ако:
        boolean isInsideFirst = ((x > x1 && x < x2) && (y > y1 && y < y2));

        //точката ще е вътрешна за горния прав. ако:
        boolean isInsideSecond = ((x > x3 && x < x4) && (y > y3 && y < y4));

        //точката ще бъде вътрешна за цялата фигура, ако е вътрешна за двата прав. или лежи на общата им стена
        boolean commonBorder = x >= x3 && x <= y3;
        boolean isInside = isInsideFirst || isInsideSecond || commonBorder;

        //точката ще е външна ако е извън един от двата прав.
        boolean isOutsideFirst = ((x < x1 || x > x2) || (y < y1 || y > y2));
        boolean isOutsideSecond = ((x < x3 || x > x4) || (y < y3 ||  y > y4));
        boolean isOutside = isOutsideFirst || isOutsideSecond;

        if (isInside) {
            System.out.println("inside");
        } else if (isOutside) {
            System.out.println("outside");
        } else {
            System.out.println("border");
        }
    }
}
