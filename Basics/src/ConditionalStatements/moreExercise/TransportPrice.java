package ConditionalStatements.moreExercise;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int kilometres = Integer.parseInt(scanner.nextLine());
        String period = scanner.nextLine();

        // bus => n >= 20
        // train => n >= 100
        //taxi => n < 20

        double priceTaxi = 0.70;
        double priceBus = 0.09;
        double priceTrain = 0.06;
        double result = 0.00;

        if (kilometres < 20) { //ще използвам такси
            switch (period) {
                case "day":
                    result = priceTaxi + (kilometres * 0.79);
                    break;
                case "night":
                    result = priceTaxi + (kilometres * 0.90);
                    break;
            }

        } else if ((kilometres >= 20) && (kilometres < 100)) { // ще използвам автобус
            result = priceBus * kilometres;

        } else { //>= 100 ще използвам влак
            result = priceTrain * kilometres;

        }
        System.out.printf("%.2f", result);

    }
}