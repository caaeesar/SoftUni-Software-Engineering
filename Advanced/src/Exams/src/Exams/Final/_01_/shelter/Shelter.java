package Exams.Final._01_.shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (this.data.size() < this.capacity) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal animal : this.data) {
            if (animal.getName().equals(name)) {
                this.data.remove(animal);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (Animal animal : this.data) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                return animal;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        int maxAge = Integer.MIN_VALUE;
        Animal oldestAnimal = null;
        for (Animal animal : this.data) {
            if (animal.getAge() > maxAge) {
                oldestAnimal = animal;
                maxAge = animal.getAge();
            }
        }
        return oldestAnimal;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append("The Exams.Final.myExam._01_.shelter has the following animals:");
        statistics.append(System.lineSeparator());
        for (Animal animal : this.data) {
            statistics.append(animal.getName());
            statistics.append(" ");
            statistics.append(animal.getCaretaker());
            statistics.append(System.lineSeparator());
        }
        return statistics.toString();
    }
}
