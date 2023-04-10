package FirstStepsInCoding.moreExercise;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double side = Double.parseDouble(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());
        double area = side * h / 2;

        System.out.printf("%.2f", area);
      //  System.out.print(String.format("%.2f", area)); друг начин за принтиране
    }
}
