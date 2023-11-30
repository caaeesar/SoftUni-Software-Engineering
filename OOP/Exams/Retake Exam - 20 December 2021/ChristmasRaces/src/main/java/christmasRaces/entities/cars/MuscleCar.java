package christmasRaces.entities.cars;

public class MuscleCar extends BaseCar {

    private static final double DEFAULT_CUBIC_CENTIMETERS = 5000;
    public static final int MINIMUM_HP = 400;
    public static final int MAXIMUM_HP = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, DEFAULT_CUBIC_CENTIMETERS);
    }

    @Override
    protected boolean isInRange(int horsePower) {
        // [400 - 600]
        return horsePower >= MINIMUM_HP && horsePower <= MAXIMUM_HP;
    }
}
