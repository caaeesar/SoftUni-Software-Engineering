package ConditionalStatementsAdvanced.moreExercise;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int chrysanthemums = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int tulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        char holiday = scanner.nextLine().charAt(0);

        double priceChrysanthemums = 0.00;
        double priceRoses = 0.00;
        double priceTulips = 0.00;

        switch (season) {
            case "Spring":
            case "Summer":
                priceChrysanthemums = 2.00;
                priceRoses = 4.10;
                priceTulips = 2.50;
                break;
            case "Autumn":
            case "Winter":
                priceChrysanthemums = 3.75;
                priceRoses = 4.50;
                priceTulips = 4.15;
                break;
        }
        double totalPrice = (priceChrysanthemums * chrysanthemums) + (priceRoses * roses) + (priceTulips * tulips);
        switch (holiday) {
            case 'Y':
                totalPrice += totalPrice * 0.15;
                break;
            /* case 'N':
                totalPrice = totalPrice;
                break; */
        }
        //отстъпките се наслагват, затова използваме if
        if (tulips > 7 && "Spring".equals(season)) {
            totalPrice -= totalPrice * 0.05;
        }
        if (roses >= 10 && "Winter".equals(season)) {
            totalPrice -= totalPrice * 0.10;
        }
        int allFlowers = chrysanthemums + roses + tulips;
        if (allFlowers > 20) {
            totalPrice -= totalPrice * 0.20;
        }

        System.out.printf("%.2f",totalPrice + 2);
    }
}
