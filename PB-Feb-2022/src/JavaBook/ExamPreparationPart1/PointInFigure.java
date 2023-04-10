package JavaBook.ExamPreparationPart1;

import java.util.Scanner;

public class PointInFigure {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());

        // фигурата се разделя на два правоъгълника:
        // за първия прав. x (2 ; 12); / y (-3 ; 1) => (x и y трябва да бъдат между тези кординати)
        // за втория прав. x (4 ; 10); / y (-5 ; 3) => (x и y трябва да бъдат между тези кординати)

        boolean firstRectangle = (x >= 2 &&  x <= 12) && (y >= -3 && y <= 1);
        boolean secondRectangle = (x >= 4 &&  x <= 10) && (y >= -5 && y <= 3);

        if (firstRectangle || secondRectangle) {
            System.out.print("in");
        } else {
            System.out.print("out");
        }
    }
}
