package Exams.Retake._03_.easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.data.size() < this.capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                this.data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        Egg strongestEgg = null;
        int maxStrength = Integer.MIN_VALUE;
        for (Egg egg : this.data) {
            int currentStrength = egg.getStrength();
            if (currentStrength > maxStrength) {
                maxStrength = currentStrength;
                strongestEgg = egg;
            }
        }
        return strongestEgg;
    }

    public Egg getEgg(String color) {
        for (Egg egg : this.data) {
            if (egg.getColor().equals(color)) {
                return egg;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append(String.format("%s basket contains:", this.material));
        report.append(System.lineSeparator());
        for (Egg egg : this.data) {
            report.append(egg);
            report.append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
