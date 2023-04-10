package WorkingWithAbstraction.lab.HotelReservation;

public class PriceCalculator {

    public static double calculatePrice(double pricePerDay,int numberOfDays,Season season,Discount discount) {
        double totalPrice = (pricePerDay * season.multiplier) * numberOfDays;
       totalPrice -= (totalPrice * (discount.percent / 100.00));
       return totalPrice;
    }
}
