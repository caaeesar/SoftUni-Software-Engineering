package Encapsulation.exercises.PizzaCalories;

public class Topping {

   private enum Modifiers {
        Meat(1.2),
        Veggies(0.8),
        Cheese(1.1),
        Sauce(0.9);

        final double calories;

        Modifiers(double calories) {
            this.calories = calories;
        }
    }

    private static final int BASE_CALORIES_PER_GRAM = 2;
    private static final String MEAT = "Meat";
    private static final String VEGGIES = "Veggies";
    private static final String CHEESE = "Cheese";
    private static final String SAUCE = "Sauce";

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        if (!MEAT.equals(toppingType)
                && !VEGGIES.equals(toppingType)
                && !CHEESE.equals(toppingType)
                && !SAUCE.equals(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (BASE_CALORIES_PER_GRAM * this.weight)
                * Modifiers.valueOf(this.toppingType).calories;
    }

}
