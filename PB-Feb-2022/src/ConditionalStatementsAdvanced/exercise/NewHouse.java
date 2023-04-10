package ConditionalStatementsAdvanced.exercise;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] argument) {
        Scanner scanner = new Scanner(System.in);

        String flower = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine()); //брой цветя
        int budget = Integer.parseInt(scanner.nextLine());

        int priceRoses = 5;
        double priceDahlias = 3.80;
        double priceTulips = 2.80;
        int priceNarcis = 3;
        double priceGladiolus = 2.50;

        double totalPrice = 0.00; //крайна цена

        switch (flower) {
            case "Roses":
                totalPrice = count * priceRoses;
                if (count > 80) {
                    totalPrice -= totalPrice * 0.1;
                }
                break;

            case "Dahlias":
                totalPrice = count * priceDahlias;
                if (count > 90) {
                    totalPrice -= totalPrice * 0.15;
                }
                break;

            case "Tulips":
                totalPrice = count * priceTulips;
                if (count > 80) {
                    totalPrice -= totalPrice * 0.15;
                }
                break;

            case "Narcissus":
                totalPrice = count * priceNarcis;
                if (count < 120) {
                    totalPrice += totalPrice * 0.15;
                }
                break;

            case "Gladiolus":
                totalPrice = count * priceGladiolus;
                if (count < 80) {
                    totalPrice += totalPrice * 0.2;
                }
                break;
        }

        boolean isEnough = budget >= totalPrice;
        if (isEnough) {
            double leftMoney = budget - totalPrice;

            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, flower, leftMoney);
        } else {
            double needMoney = totalPrice - budget;
            System.out.printf("Not enough money, you need %.2f leva more.", needMoney);
        }

    }
}
