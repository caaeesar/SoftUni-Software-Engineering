package FirstStepsInCoding.moreExercise;

import java.util.Scanner;

public class CircleAreaAndPerimeter {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        double r = Double.parseDouble(scan.nextLine());

        double area = Math.pow(r,2) * Math.PI;
        double perimeter = 2 * ( r * Math.PI);

        System.out.printf ("%.2f%n%.2f", area,perimeter);
    }
}
