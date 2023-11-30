package restaurant.entities.drinks;

public class Smoothie extends BaseBeverage {

    protected static final double smoothiePrice = 4.50;

    public Smoothie(String name, int counter, String brand) {
        super(name, counter, smoothiePrice, brand);
    }
}
