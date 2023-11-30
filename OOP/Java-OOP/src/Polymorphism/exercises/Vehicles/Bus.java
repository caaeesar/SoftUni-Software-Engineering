package Polymorphism.exercises.Vehicles;

public class Bus extends Vehicle {

    boolean isEmpty = false;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected double getExtraFuelConsumption() {
        if (isEmpty) {
            return 0;
        }

        return 1.4;
    }

    @Override
    public Double driving(double distance) {
        Double result = super.driving(distance);
        isEmpty = false;
        return result;
    }

  /*  @Override
    protected double getExtraFuelConsumption() {
        if (!isEmpty) {
            return 1.4;
        }
        return 0;
    }*/

   /* public void setNotEmptyState() {
        isEmpty = false;
    }*/

    public void setEmptyState() {
        this.isEmpty = true;
    }
}
