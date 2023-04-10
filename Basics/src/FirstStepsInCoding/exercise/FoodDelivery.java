package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int chickenMenu = Integer.parseInt(scan.nextLine());
        int fishMenu = Integer.parseInt(scan.nextLine());
        int vegetarianMenu = Integer.parseInt(scan.nextLine());

        double priceChicken = chickenMenu * 10.35;
        double priceFish = fishMenu * 12.40;
        double priceVegetarian = vegetarianMenu * 8.15;
        double totalSum = priceFish + priceChicken + priceVegetarian;

        double dessert = totalSum * 0.2;
        double result = totalSum + dessert + 2.50;

        System.out.println(result);
    }
}
