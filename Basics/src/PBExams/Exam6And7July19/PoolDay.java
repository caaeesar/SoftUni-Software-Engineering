package PBExams.Exam6And7July19;

import java.util.Scanner;

public class PoolDay {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int totalPeople = Integer.parseInt(scanner.nextLine());
        double singleFee = Double.parseDouble(scanner.nextLine());
        double priceSunBed = Double.parseDouble(scanner.nextLine());
        double priceBeachUmbrella = Double.parseDouble(scanner.nextLine());

        double tax = totalPeople * singleFee;
        double peopleWantSunBed = Math.ceil(totalPeople * 0.75);
        double totalPriceSunBed = peopleWantSunBed * priceSunBed;
        double peopleUseUmbrella = Math.ceil(totalPeople / 2.00);
        double totalPriceUmbrella = peopleUseUmbrella * priceBeachUmbrella;

        double result = tax + totalPriceUmbrella + totalPriceSunBed;

        System.out.printf("%.2f lv.", result);
    }
}
