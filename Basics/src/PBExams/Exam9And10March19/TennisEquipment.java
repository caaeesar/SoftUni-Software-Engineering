package PBExams.Exam9And10March19;

import java.util.Scanner;

public class TennisEquipment {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double priceTennisRacket = Double.parseDouble(scanner.nextLine());
        int tennisRackets = Integer.parseInt(scanner.nextLine());
        int trainers = Integer.parseInt(scanner.nextLine());
        double priceTrainers = priceTennisRacket / 6;
        double trainersAndRackets = (priceTrainers * trainers) + (priceTennisRacket * tennisRackets);
        double otherEquipment = trainersAndRackets * 0.2;

        double totalPrice = otherEquipment + trainersAndRackets;

        double paidByHim = Math.floor(totalPrice / 8);
        double paidBySponsors = Math.ceil(totalPrice * 7 / 8);

        System.out.printf("Price to be paid by Djokovic %.0f%n", paidByHim);
        System.out.printf("Price to be paid by sponsors %.0f", paidBySponsors);

    }
}
