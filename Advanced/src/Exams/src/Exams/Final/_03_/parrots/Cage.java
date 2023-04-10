package Exams.Final._03_.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                return this.data.remove(parrot);
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrots = new ArrayList<>();
        for (Parrot parrot : this.data) {
            if (parrot.getSpecies().equals(species)) {
                parrots.add(parrot);
            }
        }
        return parrots;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append(String.format("Parrots available at %s:\n", this.name));

        for (Parrot parrot : this.data) {
            if (parrot.isAvailable()) {
                report.append(parrot).append("\n");
            }
        }
        return report.toString().trim();
    }
}
