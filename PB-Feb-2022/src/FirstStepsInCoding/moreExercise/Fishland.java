package FirstStepsInCoding.moreExercise;

import java.util.Scanner;

public class Fishland {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double priceMackerel = Double.parseDouble(scan.nextLine()); // скумрия
        double priceSprat = Double.parseDouble(scan.nextLine());   //цаца

        double kgBonito = Double.parseDouble(scan.nextLine()); //паламуд
        double kgScad = Double.parseDouble(scan.nextLine());  // сафрид
        int kgMussels = Integer.parseInt(scan.nextLine()); //миди

        // price * kg => price = priceMackerel + (priceMackerel * 0.6)

        double priceBonito = (priceMackerel + (priceMackerel * 0.6)) * kgBonito;
        double priceScad = (priceSprat + (priceSprat * 0.8)) * kgScad;
        double priceMussels = kgMussels * 7.5;

        double bill = priceBonito + priceMussels + priceScad;

        System.out.printf("%.2f", bill);

    }
}
