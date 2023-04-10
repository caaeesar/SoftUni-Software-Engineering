package ForLoop.moreExercise;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int lastCargo = Integer.parseInt(scanner.nextLine());
        int priceOfTon1 = 0;
        int priceOfTon2 = 0;
        int priceOfTon3 = 0;
        int minibusTonnage = 0;
        int truckTonnage = 0;
        int trainTonnage = 0;
        int totalTonnage = 0;

        for (int cargo = 1; cargo <= lastCargo; cargo++) {
            int tonnage = Integer.parseInt(scanner.nextLine());
            totalTonnage += tonnage; // общо всички товари колко тона са;

            if (tonnage <= 3) { // микробус
                priceOfTon1 = 200;
                minibusTonnage += tonnage; // общо колко тона ще превози микробуса;
            } else if (tonnage <= 11) { // камион
                priceOfTon2 = 175;
                truckTonnage += tonnage; // -----//------
            } else if (tonnage >= 12) { // влак
                priceOfTon3 = 120;
                trainTonnage += tonnage;
            }
        }
        // средната цена на тон превозен товар:
                          // цената за превозения товар с микробус   +     // цената за камион      +    // цената за влак
        double averagePrice = 1.00 * ((minibusTonnage * priceOfTon1) + (truckTonnage * priceOfTon2) + (trainTonnage * priceOfTon3)) / totalTonnage;

        // колко % от тоновете се превозват с различните превозни средства;
        double percent1 = (minibusTonnage * 1.00 / totalTonnage) * 100;
        double percent2 = (truckTonnage * 1.00 / totalTonnage) * 100;
        double percent3 = (trainTonnage * 1.00 / totalTonnage) * 100;

        System.out.printf("%.2f\n", averagePrice);
        System.out.printf("%.2f%%\n", percent1);
        System.out.printf("%.2f%%\n", percent2);
        System.out.printf("%.2f%%", percent3);
    }
}
