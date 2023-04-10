package ObjectsAndClasses.moreExercise.carSalesman;

public class Engine {
    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    Engine(String model, int power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public int getPower() {
        return this.power;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }

    public String getModel() {
        return this.model;
    }
}
