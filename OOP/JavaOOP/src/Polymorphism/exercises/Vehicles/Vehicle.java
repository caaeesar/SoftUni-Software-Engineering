package Polymorphism.exercises.Vehicles;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption; // in liters per km
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

  /*  public String driving(double distance) {
        double neededFuel = distance * (this.fuelConsumption + getExtraFuelConsumption());
        if (this.fuelQuantity >= neededFuel) {
            this.fuelQuantity -= neededFuel;
            DecimalFormat df = new DecimalFormat("#.##");
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
        } else {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }
    }*/

    public Double driving(double distance) {
        double fuelRequired = distance * (this.fuelConsumption + getExtraFuelConsumption());

        if (fuelRequired > this.fuelQuantity) {
            return null;
        }
        this.fuelQuantity -= fuelRequired;
        return distance;
    }

    protected void refueling(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + liters > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += calculateRealLitersAfterLose(liters);
    }

    protected double calculateRealLitersAfterLose(double liters) {
        return liters;
    }

    protected abstract double getExtraFuelConsumption();

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

}
