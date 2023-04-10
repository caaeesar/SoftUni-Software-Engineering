package ObjectsAndClasses.exercise.vihicleCatalogue;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    Vehicle(String type, String model, String color, int horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public String getType() {
        return this.type;
    }

    public String getModel() {
        return this.model;
    }

    public void setType(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Type: %s\nModel: %s\nColor: %s\nHorsepower: %d",
                this.type, this.model, this.color, this.horsepower);
    }
}
