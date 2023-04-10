package ConditionalStatements.moreExercise;

import java.util.Scanner;

public class FuelTankPart2 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String typeFuel = scanner.nextLine();
        double litresFuel = Double.parseDouble(scanner.nextLine());
        String clubCard = scanner.nextLine();
        double priceGas = 0.93;
        double priceGasoline = 2.22;
        double priceDiesel = 2.33;
        double price = 0.00;
        double discountCard = 0.00;
        double discount = 0.00;

        switch (typeFuel) {
            case "Gas":
                price = litresFuel * priceGas;
                break;
            case "Gasoline":
                price = litresFuel * priceGasoline;
                break;
            case "Diesel":
                price = litresFuel * priceDiesel;
                break;
        }
       if (clubCard.equals("Yes")){
           switch (typeFuel) {
               case "Gas":
                   discountCard = priceGas - 0.08;
                   price = litresFuel * discountCard;
                   break;
               case "Gasoline":
                   discountCard = priceGasoline - 0.18;
                   price = litresFuel * discountCard;
                   break;
               case "Diesel":
                   discountCard = priceDiesel - 0.12;
                   price = litresFuel * discountCard;
                   break;
               default:
                   break;
           }
       }
       if ((litresFuel >= 20) && (litresFuel <= 25)) {
           discount = price * 0.08;
           price -= discount;
       } else if (litresFuel > 25){
           discount = price * 0.1;
           price -= discount;
       }

        System.out.printf("%.2f lv.",price);
    }
}
