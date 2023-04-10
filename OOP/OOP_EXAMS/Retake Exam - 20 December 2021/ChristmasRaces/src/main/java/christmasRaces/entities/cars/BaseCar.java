package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;
import static christmasRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car {

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    protected BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    private void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < 4) { //todo =
            String msg = String.format(INVALID_MODEL, model, 4);
            throw new IllegalArgumentException(msg);
        }
        this.model = model;
    }

    private void setHorsePower(int horsePower) {
        if (!isInRange(horsePower)) {
            String msg = String.format(INVALID_HORSE_POWER, horsePower);
            throw new IllegalArgumentException(msg);
        }
        this.horsePower = horsePower;
    }

    protected abstract boolean isInRange(int horsePower);

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.getCubicCentimeters() / this.getHorsePower() * laps;
    }
}
