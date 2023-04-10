package FirstStepsInCoding.moreExercise;

import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        // vegetables => N lv. na kg
        // fruits => M lv. na kg

        double priceVeg = Double.parseDouble(scan.nextLine());
        double priceFr = Double.parseDouble(scan.nextLine());
        int vegetablesKg = Integer.parseInt(scan.nextLine());
        int fruitsKg = Integer.parseInt(scan.nextLine());

        double sum = ((priceVeg * vegetablesKg) + (priceFr * fruitsKg)) / 1.94;

        System.out.printf("%.2f", sum);
    }
}
