package WorkingWithAbstraction.lab.HotelReservation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {

        String[] information = Arrays.stream(new Scanner(System.in)
                .nextLine()
                .split("\\s+"))
                .toArray(String[]::new);

        double pricePerDay = Double.parseDouble(information[0]);
        int numberOfDays = Integer.parseInt(information[1]);
        Season season = Season.valueOf(information[2]);
        Discount discount = Discount.valueOf(information[3]);

        double result = PriceCalculator.calculatePrice(pricePerDay,numberOfDays,season,discount);

        System.out.printf("%.2f",result);
    }
}
