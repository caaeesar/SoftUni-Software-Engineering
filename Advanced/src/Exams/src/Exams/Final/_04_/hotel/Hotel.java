package Exams.Final._04_.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : this.roster) {
            if (person.getName().equals(name)) {
                return this.roster.remove(person);
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : this.roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                return person;
            }
        }
        return null;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder statistic = new StringBuilder();
        statistic.append(String.format("The people in the Exams.Final._04_.hotel %s are:\n", this.name));
        for (Person person : this.roster) {
            statistic.append(person);
            statistic.append(System.lineSeparator());
        }
        return statistic.toString().trim();
    }
}
