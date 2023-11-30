package Encapsulation.exercises.PizzaCalories;

public class Dough {

   private enum Modifiers {
        White(1.5),
        Wholegrain(1.0),
        Crispy(0.9),
        Chewy(1.1),
        Homemade(1.0);

        final double calories;

        Modifiers(double calories) {
            this.calories = calories;
        }
    }

    private static final int BASE_CALORIES_PER_GRAM = 2;
    private static final String WHITE = "White";
    private static final String WHOLEGRAIN = "Wholegrain";
    private static final String CRISPY = "Crispy";
    private static final String CHEWY = "Chewy";
    private static final String HOMEMADE = "Homemade";

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public void setFlourType(String flourType) {
        if (!WHITE.equals(flourType) && !WHOLEGRAIN.equals(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public void setBakingTechnique(String bakingTechnique) {
        if (!CRISPY.equals(bakingTechnique) && !CHEWY.equals(bakingTechnique)
                && !HOMEMADE.equals(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        return (BASE_CALORIES_PER_GRAM * this.weight)
                * Modifiers.valueOf(this.flourType).calories
                * Modifiers.valueOf(this.bakingTechnique).calories;
    }

}
