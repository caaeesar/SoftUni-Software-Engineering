package ObjectsAndClasses.exercise.opinionPoll;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s - %s",this.name,this.age);
    }
}
