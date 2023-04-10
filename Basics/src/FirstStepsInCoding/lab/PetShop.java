package FirstStepsInCoding.lab;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int dogsFood = Integer.parseInt(scan.nextLine());
        int catsFood = Integer.parseInt(scan.nextLine());

        double totalSum = (dogsFood * 2.50) + (catsFood * 4);

        System.out.println(totalSum + " lv.");
    }
}
