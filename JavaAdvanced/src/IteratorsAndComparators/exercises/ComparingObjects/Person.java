package IteratorsAndComparators.exercises.ComparingObjects;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person other) {
        // equals names
       if (this.name.equals(other.name)) {
           if (this.age == other.age) { // equals ages
               return this.town.compareTo(other.town);
           }
       }
       return this.name.compareTo(other.name);
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(town, person.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, town);
    }
}
