package WorkingWithAbstraction.lab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bottomLeftX = coordinates[0];
        int bottomLefty = coordinates[1];
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];

        Point bottomLeft = new Point(bottomLeftX,bottomLefty);
        Point topRight = new Point(topRightX,topRightY);

        Rectangle rectangle = new Rectangle(bottomLeft,topRight);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            coordinates =  Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int x = coordinates[0];
            int y = coordinates[1];

            Point point = new Point(x,y);

            System.out.println(rectangle.contains(point));
        }
    }
}
