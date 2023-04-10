package JavaBook.ExamPreparationPart1;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // когато имаме дадени кординати на фигура:
        // от по-голямото x или y вадим по-малкото x или y, като разликата е страната/височината, която търсим;

        // (y) ордината -> вертикално;
        // (x) абсциса -> хоризонтално;

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        int x3 = Integer.parseInt(scanner.nextLine());
        int y3 = Integer.parseInt(scanner.nextLine());

        // може да използваме и Math.abs //
        double h = Math.max(y1, y2) - Math.min(y1, y2); // тъй като търсим височината използваме ординатата;
        double a = Math.max(x3,x2) - Math.min(x3,x2);   // при намиране на страната използваме абсцисата;

        double area = (a * h) / 2; // формула за намиране на лице на триъгълник;
        System.out.print(area);

    }
}
