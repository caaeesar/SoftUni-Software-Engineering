package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class Repainting {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int nylon = Integer.parseInt(scan.nextLine());
        int paint = Integer.parseInt(scan.nextLine());
        int thinner = Integer.parseInt(scan.nextLine());
        int jobHours = Integer.parseInt(scan.nextLine());

        double priceNylon = (nylon + 2) * 1.50;
        double pricePaint = (paint + (paint * 0.1 )) * 14.50 ;
        double priceThinner = thinner * 5.00;
        double price = (priceNylon + pricePaint + priceThinner + 0.40);
        double chargeForHour = price * 0.3;

        double totalPrice = price + (chargeForHour * jobHours);

        System.out.println(totalPrice);
    }
}
