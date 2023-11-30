package Polymorphism.exercises.Vehicles;

public class Truck extends Vehicle {

    private static final double LOST_FUEL = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
    }

    @Override
    protected double getExtraFuelConsumption() {
        return 1.6;
    }

    @Override
    protected double calculateRealLitersAfterLose(double liters) {
        return liters * LOST_FUEL;
    }

}
