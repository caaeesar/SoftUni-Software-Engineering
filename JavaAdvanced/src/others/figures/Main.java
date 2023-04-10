package others.figures;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] arguments) {

        Shape triangle = new Triangle(4,5);
        Shape rectangle = new Rectangle(5,7);

        List<Integer> figuresAreaList = new ArrayList<>();
        figuresAreaList.add(triangle.calculateSurface());
        figuresAreaList.add(rectangle.calculateSurface());

        figuresAreaList.forEach(System.out::println);
    }
}
