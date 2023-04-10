package Exams.Retake._02_.sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.data.size() < capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
       for (Elephant elephant : this.data){
           if (elephant.getName().equals(name)){
               return this.data.remove(elephant);
           }
       }
       return false;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant elephant : this.data){
            if (elephant.getRetiredFrom().equals(retiredFrom)){
                return elephant;
            }
        }
       return null;
    }

    public Elephant getOldestElephant(){
        Elephant oldestElephant = null;
        int oldestAge = Integer.MIN_VALUE;

        for (Elephant elephant : this.data){

            if (elephant.getAge() > oldestAge){
                oldestAge = elephant.getAge();
                oldestElephant = elephant;
            }
        }
        return oldestElephant;
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport(){
        StringBuilder report = new StringBuilder();
        report.append("Saved elephants in the park:");
        report.append(System.lineSeparator());
        for (Elephant elephant : this.data){
            String name = elephant.getName();
            String retiredFrom = elephant.getRetiredFrom();
            report.append( String.format("%s came from: %s",name,retiredFrom));
            report.append(System.lineSeparator());
        }
        return report.toString();
    }

}
