package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pens = Integer.parseInt(scan.nextLine());
        int markers = Integer.parseInt(scan.nextLine());
        int cleanLitres = Integer.parseInt(scan.nextLine());
        int percent = Integer.parseInt(scan.nextLine());

        double totalPrice = ((pens * 5.80) + (markers * 7.20) + (cleanLitres * 1.20));
        double discount = totalPrice * (percent / 100.0);
        double result = (totalPrice - discount);

        System.out.print(result);
    }
}
