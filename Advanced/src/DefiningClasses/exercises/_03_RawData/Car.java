package DefiningClasses.exercises._03_RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tiresList) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tiresList;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public boolean isValidPressures() {
        for (Tire tire : this.tires) {
            if (tire.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidEngine() {
        return this.engine.getPower() > 250;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
