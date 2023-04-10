package FirstStepsInCoding.lab;

import java.util.Scanner;

public class RectangleArea {
    public static void main (String[] args){
        Scanner scan = new Scanner (System.in);

        int a = Integer.parseInt (scan.nextLine ());
        int b = Integer.parseInt (scan.nextLine());
        int area = a * b;

        System.out.print (area);

    }
}
