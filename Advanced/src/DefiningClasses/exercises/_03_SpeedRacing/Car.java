package DefiningClasses.exercises._03_SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distanceTraveled = 0;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
    }

    public double getTotalKmCost(double amountOfKm) {
        return amountOfKm * this.fuelCostFor1km;
    }

    public boolean canMove(double totalKmCost) {
        return fuelAmount >= totalKmCost;
    }

    public void decreasingFuelAmount(double totalKmCost) {
       this.fuelAmount -= totalKmCost;
    }

    public void increasingDistance(int amountOfKm) {
        this.distanceTraveled += amountOfKm;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",this.model,this.fuelAmount,this.distanceTraveled);
    }
}
